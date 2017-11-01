package MyAList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> a1 = new MyArrayList<String>();
        a1.add("M");
        a1.add("ASD");

        MyArrayList<String> a2 = new MyArrayList<String>();
        a2.add("TEXT");

        Collections.copy(a1,a2);
        System.out.println("ArrayList1 after addAll:"+a1);
    }
}
