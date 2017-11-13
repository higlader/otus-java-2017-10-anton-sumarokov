package MyAList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> str1 = new MyArrayList<>();
        str1.add(0,"A");

        for (String str : str1) {
            System.out.println("String = " + str);
        }
    }

 }

