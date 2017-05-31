package multiThread;

/**
 * Created by caoyuncong on
 * 2017/5/13 9:06
 * over.
 */
// 6. 编写一个程序，子线程循环 10 次，接着主线程循环 100 次，
// 接着又回到子线程循环 10 次，接着再回到主线程又循环 100 次，如此循环
//50次
public class Thread6 {
    public static void main(String[] args) throws InterruptedException {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.sub(i);
                }
            }
        }) {
        }.start();

        Thread.sleep(1000);

        for (int i = 0; i < 50; i++) {
            business.main(i);
        }
    }
}

class Business {
    public synchronized void sub(int i) {
        for (int j = 0; j < 10; j++) {
            System.out.println(Thread.currentThread().getName() + " " + j);
        }
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void main(int i) {
        for (int j = 0; j < 100; j++) {
            System.out.println(Thread.currentThread().getName() + " " + j);
        }
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}