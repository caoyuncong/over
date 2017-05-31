package multiThread;

/**
 * Created by caoyuncong on
 * 2017/5/13 8:51
 * over.
 */
public class WaitTest {
    public synchronized void waitTest() {
        System.out.println(Thread.currentThread().getName() + "wait start");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "wait end");
    }

    public synchronized void notifyTest() {
        System.out.println(Thread.currentThread().getName() + "notify start");
        this.notify();
        System.out.println(Thread.currentThread().getName() + "notify end");
    }


}

class Test implements Runnable {
    private static WaitTest waitTest = new WaitTest();

    @Override
    public void run() {
        if (Thread.currentThread().getName().endsWith("4")) {
            waitTest.notifyTest();
            return;
        }
        waitTest.waitTest();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Test(), "thread " + i);
            thread.start();
        }
    }
}
