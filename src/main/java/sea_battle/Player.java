package sea_battle;

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

    public void fillField() {

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String[] splitLine = line.split(";");
            try {
                if (splitLine.length == 1 && !line.matches("\\d,\\d")) {
                    throw new IllegalArgumentException("n1.Некорректный ввод." +
                            " Введите координаты последнего корабля заново.");
                } else if (splitLine.length == 2 &&
                        !line.matches("\\d,\\d;\\d,\\d")) {
                    throw new IllegalArgumentException("n2.Некорректный ввод." +
                            " Введите координаты последнего корабля заново.");
                } else if (splitLine.length == 3 &&
                        !line.matches("(\\d,\\d;){2}\\d,\\d")) {
                    throw new IllegalArgumentException("n3.Некорректный ввод." +
                            " Введите координаты последнего корабля заново.");
                } else if (splitLine.length == 4 &&
                        !line.matches("(\\d,\\d;){3}\\d,\\d")) {
                    throw new IllegalArgumentException("n4.Некорректный ввод." +
                            " Введите координаты последнего корабля заново.");
                } else if (splitLine.length > 4) {
                    throw new IllegalArgumentException("4+.Некорректный ввод." +
                            " Введите координаты последнего корабля заново.");
                }

                for (int i = 0; i < splitLine.length; i++) {

                    String[] xAndY = splitLine[i].split(",");

                    int x = Integer.parseInt(xAndY[0]);
                    int y = Integer.parseInt(xAndY[1]);

                    Point pointXAndY = new Point(x, y);


                    if (shipLocationSet.contains(pointXAndY)) {
                        throw new IllegalArgumentException("Вы уже размещали корабль в этом месте.");
                    }

                    if (splitLine.length == 2 || splitLine.length == 3 ||
                            splitLine.length == 4) {
                        arrayX.add(x);
                        arrayY.add(y);
                    }

                    if (i == splitLine.length - 1 && !arrayX.isEmpty() && !arrayY.isEmpty()) {
                        if (!arrayX.get(arrayX.size() - 1).equals(arrayX.get(arrayX.size() - 2)) &&
                                !arrayY.get(arrayY.size() - 1).equals(arrayY.get(arrayX.size() - 2))) {

                            throw new IllegalArgumentException("Корабль не валиден." +
                                    "Палубы корабля не должны распологаться по диагонали." +
                                    "\nВведите координаты последнего корабля заново.");

                        } else if (!arrayX.get(arrayX.size() - 1).equals(arrayX.get(arrayX.size() - 2) - 1) &&
                                !arrayY.get(arrayY.size() - 1).equals(arrayY.get(arrayY.size() - 2) - 1) &&
                                !arrayX.get(arrayX.size() - 1).equals(arrayX.get(arrayX.size() - 2) + 1) &&
                                !arrayY.get(arrayY.size() - 1).equals(arrayY.get(arrayY.size() - 2) + 1)) {

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

                    checkHalo(dXdY, pointsMap);
                    checkHalo(uXuY, pointsMap);
                    checkHalo(dXuY, pointsMap);
                    checkHalo(uXdY, pointsMap);
                    checkHalo(uXy, pointsMap);
                    checkHalo(xuY, pointsMap);
                    checkHalo(dXy, pointsMap);
                    checkHalo(xdY, pointsMap);

                    if ((pointsMap.get(pointXAndY) == FillCharacters.HALO) && i == 0) {
                        throw new IllegalArgumentException("Вы ставите корабль в зоне ареола.");
                    }

                    battlefield[x][y] = FillCharacters.SHIP_DECK;
                    pointsMap.put(pointXAndY, FillCharacters.SHIP_DECK);
                    shipLocationSet.add(pointXAndY);
                    countOfAllDecks++;

                }

                if (countOfShips_1 > 4 || countOfShips_2 > 3 ||
                        countOfShips_3 > 2 || countOfShips_4 > 1) {
                    throw new IllegalArgumentException("Доспустимое количество таких" +
                            " кораблей достигнуто.");
                }

                switch (splitLine.length) {
                    case 1:
                        countOfShips_1++;
                        break;
                    case 2:
                        countOfShips_2++;
                        break;
                    case 3:
                        countOfShips_3++;
                        break;
                    case 4:
                        countOfShips_4++;
                        break;
                }

                countOfAllShips = countOfShips_1 + countOfShips_2 + countOfShips_3
                        + countOfShips_4;


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

    public static void checkHalo(Point point, Map<Point, FillCharacters> pointsMap) {

        if (pointsMap.get(point) != FillCharacters.SHIP_DECK) {
            pointsMap.put(point, FillCharacters.HALO);
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

            Point nPoint = new Point(x, y);

            if (strikingSet.contains(nPoint)) {
                throw new IllegalArgumentException("Сюда уже стрелял!");
            }

            strikingSet.add(nPoint);


            for (Map.Entry<Point, FillCharacters> entry : pointsMap.entrySet()) {

                if (entry.getKey().equals(nPoint) &&
                        entry.getValue().equals(FillCharacters.SHIP_DECK)) {

                    arrayStrike[x][y] = FillCharacters.DAMAGED_PART;

                    System.out.println("Попадание!");

                    countOfAllDecks--;
                    print(arrayStrike);
                    System.out.println("---------------------------------------------------------------");

                    this.striking(player);

                } else if (entry.getKey().equals(nPoint) &&
                        entry.getValue().equals(FillCharacters.HALO)) {

                    arrayStrike[x][y] = FillCharacters.MISTAKE;
                    System.out.println("Мимо!");
                    print(arrayStrike);
                    System.out.println("---------------------------------------------------------------");
                    player.striking(this);

                } else if (entry.getKey().equals(nPoint) &&
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
