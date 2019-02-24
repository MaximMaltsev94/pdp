package pdp.multithreading.advanced;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreMain {
    public static void main(String[] args) throws InterruptedException, IOException {
        AtomicInteger activeThreads = new AtomicInteger();

        Semaphore semaphore = new Semaphore(5);

        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 20; ++i) {
            Thread.sleep(200);
            executor.submit(() -> {
                semaphore.acquire();
                activeThreads.incrementAndGet();
                Thread.sleep(2000);
                activeThreads.decrementAndGet();
                semaphore.release();
                return Collections.emptyList();
            });
        }

        while (activeThreads.get() != 0) {
            Thread.sleep(50);
            System.out.println("Active threads " + activeThreads.get());
        }

        executor.shutdown();
    }
}
