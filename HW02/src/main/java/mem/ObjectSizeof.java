package mem;


import java.util.function.Supplier;

/**
 * Created by anton on 24.10.17.
 */
public class ObjectSizeof {
    int size = 1_000_000;


    public Object getSize(Supplier<Object> supplier) {
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
        String name = supplier.get().getClass().getCanonicalName();
        return ("Объект " + name + " равен: " + total + "Byte");
    }
}


