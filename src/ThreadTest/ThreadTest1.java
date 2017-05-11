package ThreadTest;

import java.util.Timer;
import java.util.concurrent.*;

/**
 * Created by sun on 2017/5/11.
 */
public class ThreadTest1 {

    static class gan extends Thread{
        @Override
        public void run() {
            System.out.printf("就是干！");
        }
    }

    public static void main(String[] args) {
        gan gan = new gan();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(gan, 1, 3, TimeUnit.SECONDS);
    }
}
