package sea_battle;

public class Player1 extends Player{


    public Player1(FillCharacters[][] battlefield, String playerName) {
        super(battlefield, playerName);
    }


}
/*
                          Player 1
  Sea                *   *   *   *   *
  Battle   |.0.|.1.|.2.|.3.|.4.|.5.|.6.|.7.|.8.|.9.|

  |.0.|     0,1;0,2;0,3;0,4 .-. .-. .-. 0,7;0,8;0,9
  |.1.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.2.|     2,0 .-. 2,2;3,2;4,2 .-. .-. 2,7 .-. 2,9
  |.3.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.4.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.5.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.6.|     6,0;6,1 .-. .-. .-. .-. .-. 6,7;6,8 .-.
  |.7.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.8.|     .-. 8,1 .-. .-. .-. .-. .-. .-. .-. .-.
  |.9.|     .-. .-. .-. 9,3;9,4 .-. .-. .-. .-. .-.

   *
   0,1;0,2;0,3;0,4
   0,7;0,8;0,9
   2,2;3,2;4,2
   6,0;6,1
   9,3;9,4
   6,7;6,8
   2,0
   2,7
   2,9
   8,1
   .
   *
                          Player 1
  Sea                *   *   *   *   *
  Battle   |.0.|.1.|.2.|.3.|.4.|.5.|.6.|.7.|.8.|.9.|

  |.0.|     0,1;0,2;0,3;0,4  -  .-.  -  0;7;0,8;0,9
  |.1.|      -   -   -   -   -   -   -   -   -   -
  |.2.|     2,0  -  2,2;3,2;4,2  -   -  2,7  -  2,9
  |.3.|      -   -   -   -   -   -   -   -   -   -
  |.4.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.5.|      -   -   -  .-. .-. .-.  -   -   -   -
  |.6.|     6,0;6,1  -  .-. .-. .-.  -  6,7;6,8  -
  |.7.|      -   -   -  .-. .-. .-.  -   -   -   -
  |.8.|      -  8,1  -   -   -   -  .-. .-. .-. .-.
  |.9.|      -   -   -  9,3;9,4  -  .-. .-. .-. .-.


                          Player 1
  Sea                *   *   *   *   *
  Battle   |.0.|.1.|.2.|.3.|.4.|.5.|.6.|.7.|.8.|.9.|

  |.0.|     0,0;0,0;0,0;0,0  -  .-.  -  0,0;0,0;0,0
  |.1.|      -   -   -   -   -   -   -   -   -   -
  |.2.|     0,0  -  0,0;0,0;0,0  -   -  0,0  -  0,0
  |.3.|      -   -   -   -   -   -   -   -   -   -
  |.4.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.5.|      -   -   -  .-. .-. .-.  -   -   -   -
  |.6.|     0,0;0,0  -  .-. .-. .-.  -  0,0;0,0  -
  |.7.|      -   -   -  .-. .-. .-.  -   -   -   -
  |.8.|      -  0,0  -   -   -   -  .-. .-. .-. .-.
  |.9.|      -   -   -  0,0;0,0  -  .-. .-. .-. .-.

 */