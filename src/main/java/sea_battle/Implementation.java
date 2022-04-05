package sea_battle;

import java.util.Scanner;

public class Implementation {


    public static void main(String[] args) {


        FillCharacters[][] arrayCharacters1 = new FillCharacters[10][10];
        FillCharacters[][] arrayCharacters2 = new FillCharacters[10][10];

        Player1 player1 = new Player1(arrayCharacters1, "Player 1");
        Player2 player2 = new Player2(arrayCharacters2, "Player 2");

        player1.fillField();
//        player2.fillField();

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
