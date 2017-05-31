package multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by caoyuncong on
 * 2017/5/13 9:10
 * over.
 */
// 编写一个程序，开启3个线程，这3个线程的 Name 分别为 A、B、C，
// 每个线程将自己的 Name 在屏幕上打印10遍，要求输出结果必须按
//ABC 的顺序显示；如：ABCABC….依次递推 15分

public class Thread7 implements Runnable {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int state = 0;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        lock.lock();
//        进入临界区
        try {
            for (int i = 0; i < 10; i++) {
                if (name.equals("B")) {
                    while (state % 3 != 1) {
                        condition.await();
                    }
                } else if (name.equals("C")) {
                    while (state % 3 != 2) {
                        condition.await();
                    }
                } else if (name.equals("A")) {
                    while (state % 3 != 0) {
                        condition.await();
                    }
                }
                state++;
                System.out.print(name);
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
//        Thread thread1 = new Thread(new Thread7(), "A");
//        Thread thread2 = new Thread(new Thread7(), "B");
//        Thread thread3 = new Thread(new Thread7(), "C");
//        thread1.start();
//        thread2.start();
//        thread3.start();
        Thread7 task = new Thread7();
             Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
                 Thread thread3 = new Thread(task);
        thread1.setName("A");
                 thread2.setName("B");
        thread3.setName("C");
                 thread1.start();
                 thread2.start();
                 thread3.start();
    }
}
