package mem;

/**
 * Created by anton on 23.10.17.
 */
import java.lang.management.ManagementFactory;

/**
 * VM options -Xmx512m -Xms512m
 * <p>
 * Runtime runtime = Runtime.getRuntime();
 * long mem = runtime.totalMemory() - runtime.freeMemory();
 * <p>
 * System.gc()
 * <p>
 * jconsole, connect to pid
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Main {
    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 1000;

        System.out.println("Starting the loop");
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        long mem = runtime.totalMemory() - runtime.freeMemory();

        while (true) {
            Object[] array = new Object[size];
            System.out.println("New array of size: " + array.length + " created");
            for (int i = 0; i < size; i++) {
                //array[i] = new Object();
                array[i] = new String(""); //String pool
                //array[i] = new String(new char[0]); //without String pool
                //array[i] = new MyClass();
            }
            System.out.println("Created " + size + " objects.");
            System.gc();
            long mem1 = runtime.totalMemory() - runtime.freeMemory();
            long total = (mem1 - mem) / size;
            System.out.println("Объект равен: " + total + "Byte");
            Thread.sleep(1000); //wait for 1 sec
        }

    }

    private static class MyClass {
        private int i = 0;
        private long l = 1;
    }
}
