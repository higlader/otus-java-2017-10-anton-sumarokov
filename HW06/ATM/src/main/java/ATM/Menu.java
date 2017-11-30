package ATM;

import java.util.Scanner;

/**
 * Created by anton on 29.11.17.
 */
public class Menu extends Transaction{

    public void menu() {
        System.out.println("Вы вошли в АТМБанк, выберите пункт меню: " +
                "\n  1. Положить деньги  \n  2. Снять деньги " + "\n  3. Запрос баланса   \n  4. Выход из системы");
        choiseMenu();
    }

    public void choiseMenu() {
        Scanner punkt = new Scanner(System.in);
        int choise;
        String choisePunkt;
        while (!punkt.hasNextInt()){
            System.out.println("Error");
            menu();
        }
        choise = punkt.nextInt();
        switch (choise) {
            case 1:
                choisePunkt = "Выберите сумму для пополнения счета: ";
                System.out.println(choisePunkt);
                sum();
                deposit();
                sum();
                break;
            case 2:
                choisePunkt = "Выберите сумму для снятия со счета: ";
                System.out.println(choisePunkt);
                sum();
                withdraw();
                sum();
                break;
            case 3:
                choisePunkt = "Запрос баланса: ";
                System.out.println(choisePunkt);
                balance();
                sum();
                break;
            case 4:
                choisePunkt = "Выход из системы ";
                System.out.println(choisePunkt);
                System.exit(0);
                break;
            default:
                choisePunkt = "Нет такого пунтка меню";
                System.out.println(choisePunkt);
                menu();
            }
    }
}




