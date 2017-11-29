package ATM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anton on 29.11.17.
 */
public class Menu {
    private String punktMenu;
    Scanner punkt = new Scanner(System.in);

    public String getPunktMenu() {
        return punktMenu;
    }

    public String choiseMenu() {
        int choise;
        System.out.println("Вы вошли в АТМБанк, выберите пункт меню: " +
                "\n  1. Положить деньги  \n  2. Снять деньги " + "\n  3. Запрос баланса   \n  4. Выход из системы");
        String[] choisePunkt = {"1.Положить деньги", "2.Снять деньги", "3.Запрос баланса", "4.Выход из системы"};
        for (int i = 0; i < choisePunkt.length; i++) {
            punktMenu = choisePunkt[i];
            choise = punkt.nextInt();
            if (choise < 1 || choise > 4) {
                System.out.println("Нет такого пунтка меню,выберите снова");
            }
            System.out.println(punktMenu);
        }
        return punktMenu ;
    }
}

