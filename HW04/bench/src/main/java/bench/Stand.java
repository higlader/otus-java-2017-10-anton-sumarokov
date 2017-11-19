package bench;

import java.util.ArrayList;

public class Stand {

    public void stand(int size) {

        int half = size / 2;
        ArrayList<String> list = new ArrayList<>(size);

        while(true) {
            for (int i = 0; i < size; i++) {
                list.add(new String(new char[0]));
            }

            for (int i = 0; i < half; i++) {
                list.remove(i);
            }

            System.out.println("Created: " + size);
            System.out.println("Removed: " + half);
            System.out.println("ArrayList: " + list.size());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

