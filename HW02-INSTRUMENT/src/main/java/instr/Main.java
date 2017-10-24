package instr;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anton on 24.10.17.
 */
public class Main {
    public static void main(String [] args) {
        System.out.println("Object");
        System.out.println(Sizeof.sizeof(new Object()));

        System.out.println("/\"\"");
        System.out.println(Sizeof.sizeof(""));

        System.out.println("/\"abc\"");
        System.out.println(Sizeof.sizeof("abc"));

        System.out.println("int[0]");
        System.out.println(Sizeof.sizeof(new int[0]));

        System.out.println("int[10]");
        System.out.println(Sizeof.sizeof(new int[10]));

        class OneInt {
            public int i;
        }
        System.out.println("OneInt");
        System.out.println(Sizeof.sizeof(new OneInt()));

        class TwoInts {
            public int i;
            public int j;
        }
        System.out.println("TwoInts");
        System.out.println(Sizeof.sizeof(new TwoInts()));

        class IntArray0 {
            int[] i = new int[0];
        }
        System.out.println("IntArray0");
        System.out.println(Sizeof.sizeof(new IntArray0()));

        class IntArray10 {
            int[] i = new int[10];
        }
        System.out.println("IntArray10");
        System.out.println(Sizeof.sizeof(new IntArray10()));

        class ListColl {
            ArrayList<String> places = new ArrayList<String>(
                    Arrays.asList("тапки","123465654","fvgdfv","dsgfsgs","235346546546"));
        }
        System.out.println("ListCollection");
        System.out.println(Sizeof.sizeof(new ListColl()));
    }
}