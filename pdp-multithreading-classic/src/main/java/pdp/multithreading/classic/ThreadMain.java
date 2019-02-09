package pdp.multithreading.classic;

import java.util.List;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        test2();
        test1();
    }

    /*
     *  Создать небольшое приложение с использованием wait/notify/synchronized
     *  в котором один поток ждет пока другой прочитает данные из консоли или файла
     *  и только после этого запишет в консоль или файл
     */
    public static void test1() throws InterruptedException {
        System.out.println("---------------------------------------------------------\\");
        System.out.println("test 1");

        SynchronizedContent lock = new SynchronizedContent();

        try (ThreadReader threadReader = new ThreadReader(System.in, lock);
                ThreadWriter threadWriter = new ThreadWriter(System.out, lock)) {

            threadReader.start();
            threadWriter.start();

            threadWriter.join();
        }

        System.out.println("---------------------------------------------------------/");
    }

    /*
     * Существует файл хранящий в себе строки.
     * При запуске main в запускается новый поток,
     * который вычитывает из файла N строк(N-любое, захардкоженное, переданное аргументом неважно).
     * Потом должен вернуть коллекцию строк из файла, а основной поток вывести их на экран.
     */
    public static void test2() {
        System.out.println("---------------------------------------------------------\\");
        System.out.println("test 2");

        String fileName = "pdp-multithreading-classic/src/main/resources/ten-thousand-lines.test.data";
        AsyncFileUtils.MyCustomFuture<List<String>> fileLines = AsyncFileUtils.readLines(fileName, 441);
        System.out.println("Read " + fileLines.get().size() + " lines");
        System.out.println(fileLines.get());

        System.out.println("---------------------------------------------------------/");
    }
}
