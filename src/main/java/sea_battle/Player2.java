package sea_battle;

import java.util.Map;
import java.util.Set;

public class Player2 extends Player{


    public Player2(FillCharacters[][] battlefield, FillCharacters[][] arrayStrike,
                   String playerName, Map<Point, FillCharacters> pointsMap,
                   Set<Point> strikingSet) {
        super(battlefield, arrayStrike, playerName, pointsMap, strikingSet);
    }
}
/*
                          Player 2
  Sea                *   *   *   *   *
  Battle   |.0.|.1.|.2.|.3.|.4.|.5.|.6.|.7.|.8.|.9.|

  |.0.|     .-. 0,1 .-. .-. .-. .-. .-. .-. 0,8 .-.
  |.1.|     .-. .-. .-. 1.3;1,4 .-. .-. .-. 1,8 .-.
  |.2.|     2,0 .-. .-. .-. .-. .-. 2,6 .-. .-. .-.
  |.3.|     3,0 .-. .-. .-. .-. .-. 3,6 .-. .-. .-.
  |.4.|     4,0 .-. .-. 4,3 .-. .-. .-. .-. .-. .-.
  |.5.|     .-. .-. .-. 5,3 .-. .-. .-. .-. .-. 5,9
  |.6.|     .-. .-. .-. 6,3 .-. .-. 6,6 .-. .-. .-.
  |.7.|     7,0 .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.8.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.9.|     .-. .-. .-. .-. 9,4;9,5;9,6;9,7 .-. .-.

   *
   9,4;9,5;9,6;9,7
   2,0;3,0;4,0
   4,3;5,3;6,3
   1,3;1,4
   0,8;1,8
   2,6;3,6
   0,1
   7,0
   6,6
   5,9
   .
   *

 */