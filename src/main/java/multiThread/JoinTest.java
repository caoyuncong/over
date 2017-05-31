package multiThread;

/**
 * Created by caoyuncong on
 * 2017/5/13 8:47
 * over.
 */
public class JoinTest implements Runnable {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new JoinTest(), "thread 1");
        Thread thread2 = new Thread(new JoinTest(), "thread 1");
        thread1.start();
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test..");
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
