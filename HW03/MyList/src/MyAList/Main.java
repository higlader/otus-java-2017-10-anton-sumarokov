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

        Collections.copy(str1,str);
        System.out.println(str1);

        Collections.addAll(str1, "A","F","G");
        System.out.println(str1);

        Collections.sort(str1);
        System.out.println(str1);
    }
}
