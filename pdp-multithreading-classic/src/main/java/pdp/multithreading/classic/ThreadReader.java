package pdp.multithreading.classic;

import java.io.InputStream;
import java.util.Scanner;

public class ThreadReader extends Thread implements AutoCloseable {
    private Scanner input;
    private final SynchronizedContent synchronizedContent;

    public ThreadReader(InputStream inputStream, SynchronizedContent synchronizedContent) {
        this.input = new Scanner(inputStream);
        this.synchronizedContent = synchronizedContent;
    }

    @Override
    public void run() {
        while (synchronizedContent.notEqualTo("quit")){
            String str = input.next();
            synchronized (synchronizedContent) {
                synchronizedContent.writeContent(str);
                synchronizedContent.notify();
            }
        }
    }

    @Override
    public void close() {
        input.close();
    }
}
