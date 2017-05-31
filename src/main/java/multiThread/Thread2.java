package multiThread;

/**
 * Created by caoyuncong on
 * 2017/5/13 8:41
 * over.
 */
public class Thread2 implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new Thread2());
        thread.start();
        System.out.println("test");
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
