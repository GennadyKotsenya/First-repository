package day7;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        System.out.println(Player.countPlayers);
        Player.info();
        Player player5 = new Player();
        Player player6 = new Player();
        System.out.println(Player.countPlayers);
        Player.info();

        Player player7 = new Player();
        System.out.println(Player.countPlayers);
        Player.info();
        System.out.println();

        while (player1.getStamina() != 0) {
            player1.run();
        }
        System.out.println(Player.countPlayers);
        Player.info();
    }
}

class Player {
    private int stamina;
    final static int MAX_STAMINA = 100;
    final static int MIN_STAMINA = 0;
    static int countPlayers;

    Random random = new Random();

    public Player() {
        stamina = random.nextInt(11) + 90;
        if (countPlayers < 6) {
            countPlayers++;
        }
    }


    public int getStamina() {
        return stamina;
    }

    public static int getCountPlayer() {
        return countPlayers;
    }

    void run() {
        if (stamina == 0)
            return;

        stamina--;

        if (stamina == MIN_STAMINA) {
            countPlayers--;
        }
    }

    static void info() {
        int countAvailableSeats = 6 - countPlayers;
        if (countPlayers < 6) {
            if (countAvailableSeats == 1) {
                System.out.printf("Команды неполные. На поле еще есть %d " +
                        "свободное место%n", countAvailableSeats);
            } else if (countAvailableSeats > 1 && countAvailableSeats < 5) {
                System.out.printf("Команды неполные. На поле еще есть %d " +
                        "свободных места%n", countAvailableSeats);
            } else if (countAvailableSeats > 4 && countAvailableSeats < 7) {
                System.out.printf("Команды неполные. На поле еще есть %d " +
                        "свободных места%n", countAvailableSeats);
            }

        } else {
            System.out.println("На поле нет свободных мест");
        }
    }
}
