package instr;
import java.lang.instrument.Instrumentation;

/**
 * Created by anton on 24.10.17.
 */


public class Sizeof {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long sizeof(Object o) {
        return instrumentation.getObjectSize(o);
    }
}
