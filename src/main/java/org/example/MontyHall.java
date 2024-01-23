package org.example;

import java.util.Random;
public class MontyHall {
    public static void main(String[] args) {
        int switchWins = 0;
        int stayWins = 0;
        Random random = new Random();
        for (int plays = 0; plays < 1000; plays++) {
            //0 — козел, 1 — машина
            int[] doors = {0, 0, 0};
            //помещаем машину в случайную дверь
            doors[random.nextInt(3)] = 1;
            //выбираем случайную дверь
            int choice = random.nextInt(3);
            //показанная дверь
            int shown;
            do {
                shown = random.nextInt(3);
            } while (doors[shown] == 1 || shown == choice);

            stayWins += doors[choice];  //если выйграл выбрав правильную дверь

            //последняя оставшаяся дверь (3 - выбор - показано), потому что 0+1+2=3
            switchWins += doors[3 - choice - shown];
        }
        System.out.println("Количество побед при неизменном выборе " + stayWins);
        System.out.println("Количество побед переключением " + switchWins);
    }
}
