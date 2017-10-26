package mem;


import java.lang.reflect.Array;

/**
 * Created by anton on 24.10.17.
 */
public class ObjectSizeof {

    public static void getSize(Object[] array) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        int size = Array.getLength(array);
        long mem = runtime.totalMemory() - runtime.freeMemory();

        while (true) {
            Object[] obj = new Object[size];
            System.out.println("New array of size: " + obj.length + " created");
            for (int i = 0; i < size; i++) {
                obj[i] = new Object[i];
            }
            System.out.println("Created " + size + " objects.");
            long mem1 = runtime.totalMemory() - runtime.freeMemory();
            System.gc();
            long total = (mem1 - mem) / size;
            System.out.println("Объект равен: " + total + "Byte");
            Thread.sleep(1000); //wait for 1 sec
        }
    }
}


