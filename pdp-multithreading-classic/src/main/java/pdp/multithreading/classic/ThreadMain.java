package pdp.multithreading.classic;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedContent lock = new SynchronizedContent();

        try (ThreadReader threadReader = new ThreadReader(System.in, lock);
                ThreadWriter threadWriter = new ThreadWriter(System.out, lock)) {

            threadReader.start();
            threadWriter.start();

            threadWriter.join();
        }
    }
}
