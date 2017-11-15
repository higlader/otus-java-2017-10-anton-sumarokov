package MyAList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myString = new MyArrayList<>();
        Collections.addAll(myString, "A", "B", "C", "D", "E", "H", "I", "L", "S", "Z");
        System.out.println(myString);

        Collections.addAll(myString, "G", "R","T");
        System.out.println(myString);

        MyArrayList<String> dest = new MyArrayList<>();
        MyArrayList<String> sourc = new MyArrayList<>();
        Collections.addAll(dest, "A", "B", "C", "D", "E", "H", "I", "L", "S", "Z");
        Collections.addAll(sourc, "G", "R","T","&","U","O","$","#","K","L");
        Collections.copy(dest, sourc);
        System.out.println(dest);

        MyArrayList<String> sortedString = new MyArrayList<>();
        Collections.addAll(sortedString,"G", "R","T","&","U","O","$","#","K","L");
        Collections.sort(sortedString);
        System.out.println(sortedString);

    }
}

