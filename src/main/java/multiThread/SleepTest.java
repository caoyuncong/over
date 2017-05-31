package multiThread;

/**
 * Created by caoyuncong on
 * 2017/5/13 8:43
 * over.
 */
public class SleepTest implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new SleepTest());
        thread.start();
        try {
            Thread.sleep(1000);
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
