package sea_battle;

import java.util.*;

public class Implementation {


    public static void main(String[] args) {


        FillCharacters[][] battlefield1 = new FillCharacters[10][10];
        FillCharacters[][] battlefield2 = new FillCharacters[10][10];
        FillCharacters[][] arrayStrike1 = new FillCharacters[10][10];
        FillCharacters[][] arrayStrike2 = new FillCharacters[10][10];

        Map<Point, FillCharacters> pointsMap1 =new HashMap<>();
        Map<Point, FillCharacters> pointsMap2 =new HashMap<>();
        Set<Point> strikingSet1 = new HashSet<>();
        Set<Point> strikingSet2 = new HashSet<>();

        Player1 player1 = new Player1(battlefield1,arrayStrike1, "Player 1",
                pointsMap1, strikingSet1);
        Player2 player2 = new Player2(battlefield2,arrayStrike2, "Player 2",
                pointsMap2, strikingSet2);

        player1.fillField();
        player2.fillField();

        player2.striking(player1);
        player1.striking(player2);
        player2.striking(player1);
        player1.striking(player2);
//        player2.striking(player1);
//        player1.striking(player2);
//        player2.striking(player1);

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
