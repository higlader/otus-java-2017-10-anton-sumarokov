package ATM;

import java.util.ArrayList;

/**
 * Created by anton on 06.12.17.
 */
public class Cell {
    ArrayList<Integer> cell = new ArrayList<Integer>();

    long balance = 0;
    long currentbalance = 0;
    long totalbalance;

    public  long deposit (int money) {
        cell.add(money);
        for (int i : cell)
            balance += i;
        return balance;
    }

    public void withdraw(int money) {
        currentbalance = balance - money;
    }

    public void balance() {
        totalbalance = balance - currentbalance;
        System.out.println(totalbalance);
    }

}
