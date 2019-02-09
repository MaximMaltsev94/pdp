package pdp.multithreading.classic;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AsyncFileUtils {

    public static MyCustomFuture<List<String>> readLines(String fileName, int count) {
        MyCustomFuture<List<String>> result = new MyCustomFuture<>(new ArrayList<>());

        Thread asyncTask = new Thread(() -> {
            try {
                List<String> lines = Files.lines(Paths.get(fileName)).limit(count).collect(Collectors.toList());
                result.setContent(lines);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        result.setOwner(asyncTask);
        asyncTask.start();
        return result;
    }

    public static class MyCustomFuture<T> {
        private T content;
        private Thread owner;

        public MyCustomFuture(T content) {
            this.content = content;
        }

        private void setContent(T content) {
            this.content = content;
        }

        private void setOwner(Thread owner) {
            this.owner = owner;
        }

        public T get() {
            try {
                owner.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return content;
        }
    }

}
