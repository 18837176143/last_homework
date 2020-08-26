import org.aspectj.weaver.ast.Var;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDesign2 {
    private final LinkedList<String> lists=new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition prod = lock.newCondition();
    private Condition cons = lock.newCondition();

    public void put(String s){
        lock.lock();
        try {
            while (lists.size() !=0){
                    prod.await();
            }
            lists.add(s);
            System.out.println(Thread.currentThread().getName()+" "+lists.peekFirst()+"prod");
            cons.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        lock.lock();
        try {
            while (lists.size() ==0){
                cons.await();
            }
            System.out.println(Thread.currentThread().getName()+" "+lists.removeFirst()+"cons");
            prod.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestDesign2 testDesign=new TestDesign2();
        for (int i=0;i<5;i++){
            int temp=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testDesign.get();
                }
            }).start();
        }

        for (int i=0;i<5;i++){
            int temp=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testDesign.put(""+temp);
                }
            }).start();
        }
    }
}
