package ThreadTest;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sun on 2017/5/11.
 */
public class ThreadTest3 {

    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void m1() throws InterruptedException {
        try {
            lock.lock();
            System.out.println("我是方法一");
            condition.await();
            System.out.println("完成。。。。");
        }finally {
            lock.unlock();
        }
    }

    public void m2(){
        try {
            lock.lock();
            System.out.println("我是方法二");
            System.out.println("我是方法二干干干！！！");
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadTest3 threadTest3 = new ThreadTest3();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadTest3.m1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadTest3.m2();
            }
        });

        thread1.start();
        thread2.start();
    }
}
