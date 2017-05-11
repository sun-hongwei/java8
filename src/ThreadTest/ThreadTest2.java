package ThreadTest;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sun on 2017/5/11.
 */
public class ThreadTest2 {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("线程1开始");
                countDownLatch.await();
                System.out.println("线程1结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread thread2 = new Thread(() -> {

            try {
                System.out.println("线程2开始");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2结束");
            countDownLatch.countDown();
        }, "t2");

        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("线程3开始");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3结束");
            countDownLatch.countDown();
        }, "t3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
