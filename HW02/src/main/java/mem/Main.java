package mem;


import com.sun.org.apache.bcel.internal.generic.D2F;
import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.lang.management.ManagementFactory;

/**
 * Created by anton on 23.10.17.
 */



public class Main {
    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());


        //ObjectSizeof<String> srt = new ObjectSizeof<>(5_000_000);
        //System.out.println(srt.getSize(String::new));
        //ObjectSizeof<Integer> s = new ObjectSizeof<>(10_000_000);
        //System.out.println(s.getSize(Object::new));
        //ObjectSizeof<Double> cl = new ObjectSizeof<>(3_000_000);
        //System.out.println(cl.getSize(D2F::new));
        ObjectSizeof<String[]> arr = new ObjectSizeof<>(3_000_000,"ADSFGFGFH");
        System.out.println(arr.getSize(StringArray::new));
    }
}