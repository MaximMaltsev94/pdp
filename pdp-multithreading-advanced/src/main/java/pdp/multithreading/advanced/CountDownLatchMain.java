package pdp.multithreading.advanced;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchMain {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 10; ++i) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is waiting");
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + " is started");
                return Collections.emptyList();
            });
        }

        Thread.sleep(3000);
        countDownLatch.countDown();

        executor.shutdown();
    }
}
