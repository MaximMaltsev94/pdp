package pdp.multithreading.classic;

import java.io.OutputStream;
import java.io.PrintWriter;

public class ThreadWriter extends Thread implements AutoCloseable {

    private final PrintWriter output;
    private final SynchronizedContent synchronizedContent;

    public ThreadWriter(OutputStream outputStream, SynchronizedContent synchronizedContent) {
        this.output = new PrintWriter(outputStream);
        this.synchronizedContent = synchronizedContent;
    }

    @Override
    public void run() {
        try {
            synchronized (synchronizedContent) {
                while (synchronizedContent.notEqualTo("quit")) {
                    synchronizedContent.wait();
                    output.println(synchronizedContent.readContent());
                    output.flush();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        output.close();
    }
}
