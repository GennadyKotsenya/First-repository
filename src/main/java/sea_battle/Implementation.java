package sea_battle;

import java.util.*;
//  в классах player, player1, player внизу оставлены образцы координат))
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
        Set<Point> shipLocationSet1 = new HashSet<>();
        Set<Point> shipLocationSet2 = new HashSet<>();

        Player1 player1 = new Player1(battlefield1,arrayStrike1, "Player 1",
                pointsMap1, strikingSet1, shipLocationSet1);
        Player2 player2 = new Player2(battlefield2,arrayStrike2, "Player 2",
                pointsMap2, strikingSet2, shipLocationSet2);


        long start = System.currentTimeMillis();

        player1.printEmptyAndFirstText();
        player1.fillField();

        long end = System.currentTimeMillis();

//        player2.printEmptyAndFirstText();
//        player2.fillField();

        System.out.println("--------------------------------------------------");

        System.out.println("Время: "+ (end-start));
        System.out.println("--------------------------------------------------");

//        play(player1,player2);


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
            System.out.println("Все корабли 'Player 2' поражены." +
                    " 'Player 1' выиграл!");
            return;
        } else  if (player1.getCountOfAllDecks() == 0){
            System.out.println("Все корабли 'Player 1' поражены." +
                    " 'Player 2' выиграл!");
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
