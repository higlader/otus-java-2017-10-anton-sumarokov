package MyAList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("A");
        str.add("B");
        str.add("E");
        ArrayList<String> str1 = new ArrayList<>();
        str1.add("E");
        str1.add("B");
        str1.add("Y");
        str1.add("Z");

        str.addAll(str1);
        System.out.println(str);
    }
}