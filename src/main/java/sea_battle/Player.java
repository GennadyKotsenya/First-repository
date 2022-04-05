package sea_battle;

import java.util.Scanner;

import static sea_battle.Implementation.print;

public abstract class Player {
    private FillCharacters[][] battlefield;
    private String playerName;
    private int countOfShips_1;
    private int countOfShips_2;
    private int countOfShips_3;
    private int countOfShips_4;

    public Player(FillCharacters[][] battlefield, String playerName) {
        this.battlefield = battlefield;
        this.playerName = playerName;
        this.countOfShips_1 = 0;
        this.countOfShips_2 = 0;
        this.countOfShips_3 = 0;
        this.countOfShips_4 = 0;
    }

    @Override
    public String toString() {
        return '\'' + playerName + '\'' +
                "\ncountOfShips_1: " + countOfShips_1 +
                "\ncountOfShips_2: " + countOfShips_2 +
                "\ncountOfShips_3: " + countOfShips_3 +
                "\ncountOfShips_4: " + countOfShips_4;
    }

    public void fillField() {

        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield.length; j++) {
                battlefield[i][j] = FillCharacters.EMPTY;
            }
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Начинаем расставлять корабли на поле '"
                + this.playerName + "'" +
                ". Другой игрок не смитри!\n" +
                this.playerName + " введи кординаты твоих кораблей.\n" +
                "Формат:\n" +
                "x,y;x,y;x,y;x,y - 1шт\n" +
                "x,y;x,y;x,y - 2шт\n" +
                "x,y;x,y - 3шт\n" +
                "x,y - 4шт\n");


        while (scanner.hasNextLine()) {


            String line = scanner.nextLine();
            String[] splitLine = line.split(";");

            if (splitLine.length == 1 && !line.matches("\\d,\\d")) {
                System.out.println("n1.Некорректный ввод. Введите координаты" +
                        " последнего корабля заново.");
                continue;
            } else if (splitLine.length == 2 &&
                    !line.matches("\\d,\\d;\\d,\\d")) {
                System.out.println("n2.Некорректный ввод. Введите координаты" +
                        " последнего корабля заново.");
                continue;
            } else if (splitLine.length == 3 &&
                    !line.matches("(\\d,\\d;){2}\\d,\\d")) {
                System.out.println("n3.Некорректный ввод. Введите координаты" +
                        " последнего корабля заново.");
                continue;
            } else if (splitLine.length == 4 &&
                    !line.matches("(\\d,\\d;){3}\\d,\\d")) {
                System.out.println("n4.Некорректный ввод. Введите координаты" +
                        " последнего корабля заново.");
                continue;
            } else if (splitLine.length > 4) {
                System.out.println("4+.Некорректный ввод. Введите координаты" +
                        " последнего корабля заново.");
                continue;
            }

            for (String s : splitLine) {

                String[] xAndY = s.split(",");
                int x = Integer.parseInt(xAndY[0]);
                int y = Integer.parseInt(xAndY[1]);


                battlefield[x][y] = FillCharacters.SHIP_DECK;
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

            if (countOfShips_1 > 4 || countOfShips_2 > 3 ||
                    countOfShips_3 > 2 || countOfShips_4 > 1) {
                continue;
            }

            int countOfAllShips = countOfShips_1 + countOfShips_2 + countOfShips_3
                    + countOfShips_4;
            print(battlefield);
            System.out.println(this);
            System.out.println("countOfAllShips=" + countOfAllShips + ";");

            if (countOfAllShips == 10) {
                System.out.println("Расстановка кораблей \"" + this.playerName +
                        "\" завершина.\n");
                break;
            }
        }
    }
}

/*

  Sea                *   *   *   *   *
  Battle   |.0.|.1.|.2.|.3.|.4.|.5.|.6.|.7.|.8.|.9.|.............................................................

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



  */