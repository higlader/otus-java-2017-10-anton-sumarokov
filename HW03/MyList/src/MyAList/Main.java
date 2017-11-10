package MyAList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> str = new MyArrayList<>();
        str.add("A");
        str.add("B");
        str.add("E");
        MyArrayList<String> str1 = new MyArrayList<>();
        str1.add("E");
        str1.add("B");
        str1.add("Y");
        str1.add("Z");

        System.out.println(str);
    }
}
