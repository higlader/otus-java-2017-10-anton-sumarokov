package mem;

/**
 * Created by anton on 23.10.17.
 */
import com.sun.org.apache.bcel.internal.generic.D2F;
import com.sun.org.apache.bcel.internal.generic.I2B;
import com.sun.org.apache.bcel.internal.generic.L2D;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.lang.management.ManagementFactory;
import java.util.Collection;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

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


        ObjectSizeof<String> srt = new ObjectSizeof<>(5_000_000);
        System.out.println(srt.getSize(String::new));
        ObjectSizeof<Integer> s = new ObjectSizeof<>(10_000_000);
        System.out.println(s.getSize(Object::new));
        ObjectSizeof<Double> cl = new ObjectSizeof<>(3_000_000);
        System.out.println(cl.getSize(D2F::new));

    }
}