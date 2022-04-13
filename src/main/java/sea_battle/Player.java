package sea_battle;

import java.io.IOException;
import java.util.*;

import static sea_battle.Implementation.print;

//
public abstract class Player {

    private FillCharacters[][] battlefield;
    private FillCharacters[][] arrayStrike;
    private String playerName;
    private int countOfShips_1;
    private int countOfShips_2;
    private int countOfShips_3;
    private int countOfShips_4;
    private int countOfAllShips;
    private int countOfAllDecks;
    private Map<Point, FillCharacters> pointsMap;
    private Set<Point> strikingSet;
    private Set<Point> shipLocationSet;

    public Player(FillCharacters[][] battlefield, FillCharacters[][] arrayStrike,
                  String playerName, Map<Point, FillCharacters> pointsMap,
                  Set<Point> strikingSet, Set<Point> shipLocationSet) {
        this.pointsMap = pointsMap;
        this.shipLocationSet = shipLocationSet;
        this.strikingSet = strikingSet;
        this.battlefield = battlefield;
        this.arrayStrike = arrayStrike;
        this.playerName = playerName;
        this.countOfShips_1 = 0;
        this.countOfShips_2 = 0;
        this.countOfShips_3 = 0;
        this.countOfShips_4 = 0;
        this.countOfAllShips = 0;
        this.countOfAllDecks = 0;
    }

    public int getCountOfAllDecks() {
        return countOfAllDecks;
    }

    @Override
    public String toString() {
        return '\'' + playerName + '\'' +
                "\ncountOfShips_1: " + countOfShips_1 +
                "\ncountOfShips_2: " + countOfShips_2 +
                "\ncountOfShips_3: " + countOfShips_3 +
                "\ncountOfShips_4: " + countOfShips_4;
    }


    Scanner scanner = new Scanner(System.in);


    public void printEmptyAndFirstText() {
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield.length; j++) {
                battlefield[i][j] = FillCharacters.EMPTY;
                pointsMap.put(new Point(i, j), FillCharacters.EMPTY);
            }
        }
        System.out.println("Начинаем расставлять корабли на поле '"
                + this.playerName + "'" +
                ". Другой игрок не смитри!\n" +
                this.playerName + " введи кординаты твоих кораблей.\n" +
                "Формат:\n" +
                "x,y;x,y;x,y;x,y - 1шт\n" +
                "x,y;x,y;x,y - 2шт\n" +
                "x,y;x,y - 3шт\n" +
                "x,y - 4шт\n");
    }

    List<Integer> arrayX = new ArrayList<>();
    List<Integer> arrayY = new ArrayList<>();
    Set<Point> haloSet = new HashSet<>();

    int i;
    String[] splitLine;

    public void fillField() {

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            splitLine = line.split(";");
            try {
                if (splitLine.length == 1 && !line.matches("\\d,\\d")) {
                    throw new IOException("n1.Некорректный ввод." +
                            " Введите координаты последнего корабля заново.");
                } else if (splitLine.length == 2 &&
                        !line.matches("\\d,\\d;\\d,\\d")) {
                    throw new IOException("n2.Некорректный ввод." +
                            " Введите координаты последнего корабля заново.");
                } else if (splitLine.length == 3 &&
                        !line.matches("(\\d,\\d;){2}\\d,\\d")) {
                    throw new IOException("n3.Некорректный ввод." +
                            " Введите координаты последнего корабля заново.");
                } else if (splitLine.length == 4 &&
                        !line.matches("(\\d,\\d;){3}\\d,\\d")) {
                    throw new IOException("n4.Некорректный ввод." +
                            " Введите координаты последнего корабля заново.");
                } else if (splitLine.length > 4) {
                    throw new IOException("4+.Некорректный ввод." +
                            " Введите координаты последнего корабля заново.");
                }


                for (i = 0; i < splitLine.length; i++) {

                    String[] xAndY = splitLine[i].split(",");

                    int x = Integer.parseInt(xAndY[0]);
                    int y = Integer.parseInt(xAndY[1]);

                    Point pointXAndY = new Point(x, y);

                        arrayX.add(0, x);
                        arrayY.add(0, y);


                    if (shipLocationSet.contains(pointXAndY)) {
                        throw new IllegalArgumentException("Вы уже размещали корабль в этом месте.");
                    }


                    if (i == splitLine.length - 1 && arrayX.size() > 1 && arrayY.size() > 1 && i != 0) {

                        if (!arrayX.get(0).equals(arrayX.get(1)) &&
                                !arrayY.get(0).equals(arrayY.get(1))) {

                            i = i + 1;
                            countOfAllDecks++;
                            throw new IllegalArgumentException("Корабль не валиден." +
                                    "Палубы корабля не должны распологаться по диагонали." +
                                    "\nВведите координаты последнего корабля заново.");

                        } else if (!arrayX.get(0).equals(arrayX.get(1) - 1) &&
                                !arrayY.get(0).equals(arrayY.get(1) - 1) &&
                                !arrayX.get(0).equals(arrayX.get(1) + 1) &&
                                !arrayY.get(0).equals(arrayY.get(1) + 1)) {

                            i = i + 1;
                            countOfAllDecks++;
                            throw new IllegalArgumentException("Корабль не валиден." +
                                    " Палубы одного корабля не должны быть разрознены." +
                                    "\nВведите координаты последнего корабля заново.");

                        }
                    }

                    int uX = x + 1;
                    int dX = x - 1;
                    int uY = y + 1;
                    int dY = y - 1;

                    Point dXdY = new Point(dX, dY);
                    Point uXuY = new Point(uX, uY);
                    Point dXuY = new Point(dX, uY);
                    Point uXdY = new Point(uX, dY);
                    Point uXy = new Point(uX, y);
                    Point xuY = new Point(x, uY);
                    Point dXy = new Point(dX, y);
                    Point xdY = new Point(x, dY);


                    checkHalo(dXdY);
                    checkHalo(dXy);
                    checkHalo(dXuY);
                    checkHalo(xdY);
                    checkHalo(xuY);
                    checkHalo(uXdY);
                    checkHalo(uXy);
                    checkHalo(uXuY);


                    shipLocationSet.add(pointXAndY);

                    if (i == 0 && haloSet.contains(pointXAndY)) {

                        i = i + 1;
                        throw new IllegalArgumentException
                                ("Вы ставите корабль в зоне ареола.");
                    }

                    haloSet.remove(pointXAndY);

                    countOfAllDecks++;

                }

                if(splitLine.length == 1 && i == 1) {

                    System.out.println("countOfShips_1, i :"+i);
                    countOfShips_1++;
                } else if(splitLine.length == 2 && i == 2) {
                    System.out.println("countOfShips_2, i :"+i);
                    countOfShips_2++;
                } else if(splitLine.length == 3 && i == 3) {
                    System.out.println("countOfShips_3, i :"+i);
                    countOfShips_3++;
                } else if(splitLine.length == 4 && i == 4) {
                    System.out.println("countOfShips_4, i :"+i);
                    countOfShips_4++;
                }



                if (countOfShips_1 > 4) {

                    countOfShips_1--;
                    countOfAllDecks--;

                    throw new IllegalArgumentException("Доспустимое количество однопалубных" +
                            " кораблей достигнуто.");

                } else if (countOfShips_2 > 3) {

                    countOfShips_2--;

                    throw new IllegalArgumentException("Доспустимое количество двухпалубных" +
                            " кораблей достигнуто.");

                } else if (countOfShips_3 > 2) {

                    countOfShips_3--;

                    throw new IllegalArgumentException("Доспустимое количество трехпалубных" +
                            " кораблей достигнуто.");

                } else if (countOfShips_4 > 1) {

                    countOfShips_4--;

                    throw new IllegalArgumentException("Доспустимое количество четырехпалубных" +
                            " кораблей достигнуто.");
                }

                countOfAllShips = countOfShips_1 + countOfShips_2 + countOfShips_3
                        + countOfShips_4;

                for (Point elementListShipDeck : shipLocationSet) {

                    battlefield[elementListShipDeck.getX()][elementListShipDeck.getY()] = FillCharacters.SHIP_DECK;
                    pointsMap.put(elementListShipDeck, FillCharacters.SHIP_DECK);
                }

                for (Point elementListHalo : haloSet) {
                    battlefield[elementListHalo.getX()][elementListHalo.getY()] = FillCharacters.HALO;
                }


                print(battlefield);


                System.out.println(this);
                System.out.println("countOfAllShips = " + countOfAllShips + ";");
                System.out.println("countOfAllDecks = " + countOfAllDecks + ";");


                if (countOfAllShips == 10 || countOfAllDecks == 20) {
                    System.out.println("Расстановка кораблей \"" + this.playerName +
                            "\" завершина.\n");
                    break;
                }

            } catch (IllegalArgumentException e) {

                System.out.println(arrayX);
                System.out.println(arrayY);
//                for (Point eachSet: shipLocationSet ){
//                    System.out.println(eachSet);
//                }

                System.out.println(e.getMessage());
                returnQuantity();
                arrayX.clear();
                arrayY.clear();
                haloSet.clear();
                System.out.println(this);
                System.out.println("countOfAllShips = " + countOfAllShips + ";");
                System.out.println("countOfAllDecks = " + countOfAllDecks + ";");

                System.out.println(arrayX);
                System.out.println(arrayY);
//                for (Point eachSet: shipLocationSet ){
//                    System.out.println(eachSet);
//                }
                System.out.println("i = "+i);

                continue;

            } catch (IOException e) {

                System.out.println(e.getMessage());
                continue;
            }

            for (int i = 0; i < arrayStrike.length; i++) {
                for (int j = 0; j < arrayStrike.length; j++) {
                    arrayStrike[i][j] = FillCharacters.EMPTY;
                }
            }
        }

    }
    public void returnQuantityI1() {

        System.out.println("Выполняется returnQuantityI1()");
        shipLocationSet.remove(new Point(arrayX.get(0), arrayY.get(0)));
    }

    public void returnQuantityI2() {

        System.out.println("Выполняется returnQuantityI2()");
        shipLocationSet.remove(new Point(arrayX.get(1), arrayY.get(1)));
        shipLocationSet.remove(new Point(arrayX.get(0), arrayY.get(0)));
        countOfAllDecks -= 2;
    }

    public void returnQuantityI3() {

        System.out.println("Выполняется returnQuantityI3()");
        shipLocationSet.remove(new Point(arrayX.get(2), arrayY.get(2)));
        shipLocationSet.remove(new Point(arrayX.get(1), arrayY.get(1)));
        shipLocationSet.remove(new Point(arrayX.get(0), arrayY.get(0)));
        countOfAllDecks -= 3;
    }

    public void returnQuantityI4() {

        System.out.println("Выполняется returnQuantityI4()");
        shipLocationSet.remove(new Point(arrayX.get(3), arrayY.get(3)));
        shipLocationSet.remove(new Point(arrayX.get(2), arrayY.get(2)));
        shipLocationSet.remove(new Point(arrayX.get(1), arrayY.get(1)));
        shipLocationSet.remove(new Point(arrayX.get(0), arrayY.get(0)));
        countOfAllDecks -= 4;
    }

    public void returnQuantity() {

        if (i == 1) {

            returnQuantityI1();

        } else if (i == 2) {

            returnQuantityI2();

        } else if (i == 3) {

            returnQuantityI3();

        } else if (i == 4) {

            returnQuantityI4();

        }
    }

    public void checkHalo(Point point) {

//        if (i > 0) {
//            System.out.println("point.getX() , point.getY() : " + point.getX() + "," + point.getY() +
//                    "; arrayX.get(1) = " + arrayX.get(1) + "; arrayY.get(1) = " + arrayY.get(1));
//        }

        if (i > 0 && shipLocationSet.contains(new Point(arrayX.get(1), arrayY.get(1))) &&
                shipLocationSet.contains(point) &&
                !point.equals(new Point(arrayX.get(1), arrayY.get(1)))) {


            countOfAllDecks++;
            i = i+1;

            throw new IllegalArgumentException("Вы ставите корабль в зоне ареола." +
                    " checkHALO .");

        }


        if (!shipLocationSet.contains(point)) {

            if (point.getX() >= 0 && point.getX() < 10 && point.getY() >= 0 && point.getY() < 10)
                haloSet.add(point);
        }

    }

    Scanner scanner1 = new Scanner(System.in);

    public void striking(Player player) {

        if (countOfAllDecks == 0) {
            return;
        }


        print(arrayStrike);

        System.out.println("countOfAllDecks = " + countOfAllDecks + ";\n");

        System.out.println(player.playerName + " Введите координаты удара.\n" +
                "Формат: x,y");

        try {

            String scanPointsLine = scanner1.next();

            if (!scanPointsLine.matches("\\d,\\d")) {
                throw new IllegalArgumentException("n1.Некорректный ввод." +
                        " Введите координаты последнего удара заново.");
            }

            String[] xAndYPoint = scanPointsLine.split(",");

            int x = Integer.parseInt(xAndYPoint[0]);
            int y = Integer.parseInt(xAndYPoint[1]);

            Point strikePoint = new Point(x, y);

            if (strikingSet.contains(strikePoint)) {
                throw new IllegalArgumentException("Сюда уже стрелял!");
            }

            strikingSet.add(strikePoint);


            for (Map.Entry<Point, FillCharacters> entry : pointsMap.entrySet()) {

                if (entry.getKey().equals(strikePoint) &&
                        entry.getValue().equals(FillCharacters.SHIP_DECK)) {

                    arrayStrike[x][y] = FillCharacters.DAMAGED_PART;

                    System.out.println("Попадание!");

                    countOfAllDecks--;
                    print(arrayStrike);
                    System.out.println("---------------------------------------------------------------");

                    this.striking(player);

                } else if (entry.getKey().equals(strikePoint) &&
                        entry.getValue().equals(FillCharacters.HALO)) {

                    arrayStrike[x][y] = FillCharacters.MISTAKE;
                    System.out.println("Мимо!");
                    print(arrayStrike);
                    System.out.println("---------------------------------------------------------------");
                    player.striking(this);

                } else if (entry.getKey().equals(strikePoint) &&
                        entry.getValue().equals(FillCharacters.EMPTY)) {

                    arrayStrike[x][y] = FillCharacters.MISTAKE;
                    System.out.println("Мимо!");
                    print(arrayStrike);
                    System.out.println("---------------------------------------------------------------");
                    player.striking(this);
                }
            }


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            striking(player);
        }

    }

}


/*

  Sea                *   *   *   *   *
  Battle Y> .0.|.1.|.2.|.3.|.4.|.5.|.6.|.7.|.8.|.9..............................................................
    X
  |.0.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.1.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.2.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.3.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.4.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.5.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.6.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.7.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.8.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
  |.9.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.

   Sea                *   *   *   *   *
 Battle Y> .0.|.1.|.2.|.3.|.4.|.5.|.6.|.7.|.8.|.9.
   X
 |.0.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
 |.1.|     .-.  -   -   -  .-. .-. .-. .-. .-. .-.
 |.2.|     .-.  -  2,2  -  .-. .-. .-. .-. .-. .-.
 |.3.|     .-.  -   -   -  .-. .-. .-. .-. .-. .-.
 |.4.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
 |.5.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
 |.6.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
 |.7.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
 |.8.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.
 |.9.|     .-. .-. .-. .-. .-. .-. .-. .-. .-. .-.


 */
