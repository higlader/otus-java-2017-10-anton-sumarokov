package mem;


import java.util.function.Supplier;

/**
 * Created by anton on 23.10.17.
 */



public class Main {
    public static void main(String... args) throws InterruptedException {

        ObjectSizeof str = new ObjectSizeof(5_000_000);

        System.out.println(str.getSize(new Supplier<Object>() {
            @Override
            public Object get() {
                return new Object();
            }
        }));

        System.out.println(str.getSize(new Supplier<Object>() {
            @Override
            public Object get() {
                return new String("");
            }
        }));


        System.out.println(str.getSize(new Supplier<Object>() {
            @Override
            public Object get() {
                return new String[0];
            }
        }));

        System.out.println(str.getSize(new Supplier<Object>() {
            @Override
            public Object get() {
                return new String[1];
            }
        }));

        System.out.println(str.getSize(new Supplier<Object>() {
            @Override
            public Object get() {
                return new String[5];
            }
        }));

    }

}