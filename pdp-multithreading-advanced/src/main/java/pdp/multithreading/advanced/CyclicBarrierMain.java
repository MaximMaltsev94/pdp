package pdp.multithreading.advanced;

import java.util.Collections;
import java.util.concurrent.*;

public class CyclicBarrierMain {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(2);

        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 10; ++i) {
            Thread.sleep(1000);
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is waiting");
                barrier.await();
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " is started");
                return Collections.emptyList();
            });
        }

        executor.shutdown();
    }
}
