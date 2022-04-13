package sea_battle;

import java.util.*;

//  в классах player2, player1, player внизу оставлены образцы координат))
//  в классе player2 оставленны координаты  ошибками расстановки

public class Implementation {

    public static void main(String[] args) {

        Player1 player1 = new Player1("Player 1");
        Player2 player2 = new Player2("Player 2");


//        long start = System.currentTimeMillis();

        player1.printEmptyAndFirstText();
        player1.fillField();

//        long end = System.currentTimeMillis();

        player2.printEmptyAndFirstText();
        player2.fillField();

//        System.out.println("--------------------------------------------------");
//        System.out.println("Время: "+ (end-start));
//        System.out.println("--------------------------------------------------");

        play(player1,player2);


    }

    public static void play(Player player1, Player player2){
        Random random = new Random();
        int a = random.nextInt(2)+1;
        if (a == 1){
            player1.striking(player2);
        } else {
            player2.striking(player1);
        }



        if (player2.getCountOfAllDecks() == 0){
            System.out.println("'Player 1' выиграл!" +
                    "\nВсе корабли 'Player 2' поражены.");
            return;
        } else  if (player1.getCountOfAllDecks() == 0){
            System.out.println("'Player 2' выиграл!" +
                    "\nВсе корабли 'Player 1' поражены.");
            return;
        }

    }

    public static void print(FillCharacters[][] battlefield) {
        System.out.println();
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield.length; j++) {
                System.out.print(battlefield[i][j].getDesignation());
            }
            System.out.println();
        }
        System.out.println();
    }

}
