import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestBlockingQueue {
    public static void main(String[] args) {
        //创建阻塞队列
        ArrayBlockingQueue<Object> arrayBlockingQueue=new ArrayBlockingQueue<>(10);
        //生产者
        Runnable product= () -> {
            while (true){
                try {
                    String s="生产者:"+Thread.currentThread().getName();
                    arrayBlockingQueue.put(s);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(product,"p1").start();
        new Thread(product,"p2").start();
    }
}
