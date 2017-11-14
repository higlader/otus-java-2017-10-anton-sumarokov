package MyAList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> my = new MyArrayList<>();
        my.add(1);
        System.out.println(my);
        for(Integer i:my) {
            System.out.println(i);
        }
    }

 }

