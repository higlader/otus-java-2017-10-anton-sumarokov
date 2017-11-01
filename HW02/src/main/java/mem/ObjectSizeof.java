package mem;


import java.lang.reflect.Array;
import java.util.function.Supplier;

/**
 * Created by anton on 24.10.17.
 */
public class ObjectSizeof<T> {
    int size;

    public ObjectSizeof(int size) {
        this.size = size;
    }

    public  <T> Object getSize(Supplier<T> supplier) {
        Object[] obj = new Object[size];
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long mem = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("New array of size: " + obj.length + " created");
        for (int i = 0; i < size; i++) {
            obj[i] = supplier.get();
        }
        runtime.gc();
        System.out.println("Created " + size + " objects.");
        long mem1 = runtime.totalMemory() - runtime.freeMemory();
        long total = (mem1 - mem)/size;
        return ("Объект равен: " + total + "Byte");
    }
}


