import java.util.LinkedList;

public class TestDesign {
    private final LinkedList<String> lists=new LinkedList<>();
    public static void main(String[] args) {
        TestDesign testDesign=new TestDesign();
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
                    testDesign.put("pro"+temp);
                }
            }).start();
        }
    }

    public  synchronized void put(String s){
        while (lists.size()!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(s);
        System.out.println(Thread.currentThread().getName()+" "+lists.peekFirst());
        this.notifyAll();
    }

    public synchronized  void  get(){
        while (lists.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" "+lists.removeFirst());
        this.notifyAll();
    }
}
