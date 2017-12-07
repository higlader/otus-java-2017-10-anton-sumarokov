package ATM;

import java.util.Scanner;

/**
 * Created by anton on 30.11.17.
 */
public class Transaction extends Cell {
    int money;

    public void sum() {
        System.out.println(
                "\n  1. 500 руб  \n  2. 1000 руб " + "\n  3. 5000 руб   \n  4. Возврат в главное меню");
        checkSum();
    }

    public void checkSum() {
        Scanner check = new Scanner(System.in);
        while (!check.hasNextInt()){
            System.out.println("Error");
            sum();
        }
        money = check.nextInt();
        switch (money) {
            case 1:
                money = 500;
                deposit(money);
                sum();
                break;
            case 2:
                money = 1000;
                deposit(money);
                sum();
                break;
            case 3:
                money = 5000;
                deposit(money);
                sum();
                break;
            case 4:
                Menu menu = new Menu();
                menu.menu();
            default:
                System.out.println("Не верная сумма");
                sum();
        }
    }
}
