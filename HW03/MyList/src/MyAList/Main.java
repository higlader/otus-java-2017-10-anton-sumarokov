package MyAList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myString = new MyArrayList<>();
        Collections.addAll(myString, "A", "B", "C", "D", "E", "H", "I", "L", "S", "Z");
        System.out.println(myString);

        Collections.addAll(myString, "G", "R","T");
        System.out.println(myString);
    }

 }

