package multiThread;

/**
 * Created by caoyuncong on
 * 2017/5/13 8:37
 * over.
 */
public class Thread1 extends Thread {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
        System.out.println("test...");
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
