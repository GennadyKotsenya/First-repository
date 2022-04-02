package day19.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Neil Alishev
 */
public class Task2 {


    public static void main(String[] args) throws FileNotFoundException {


        File file = new File("src/main/resources/taxi_cars.txt");
        Scanner scanner = new Scanner(file);

        Map<Integer, Point> mapFile = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");

            mapFile.put(Integer.parseInt(numbers[0]),
                    new Point(Integer.parseInt(numbers[1]),
                            Integer.parseInt(numbers[2])));

        }

        Set<Point> setValuesInSquare = new HashSet<>();

        inputValue(setValuesInSquare);


        int counter = 0;
        for (Map.Entry<Integer, Point> linesMap : mapFile.entrySet()) {

            if (setValuesInSquare.contains(linesMap.getValue())) {
                counter++;
                System.out.println(linesMap.getKey());
            }
        }
        System.out.println(counter);
        System.out.println(setValuesInSquare);
    }


    public static void inputValue(Set<Point> valuesInSquare) {
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Водим координаты необходимого поля.\n" +
                "Введите координаты x1 и y1 :");

        Point point1 = new Point(scanner2.nextInt(), scanner2.nextInt());

        System.out.println("Введите координаты x2 и y2:");

        Point point2 = new Point(scanner2.nextInt(), scanner2.nextInt());


        if (point1.getX() >= point2.getX() || point1.getY() >= point2.getY()) {
            System.out.println("Некорректный ввод. Введите корректное значение");
            inputValue(valuesInSquare);

        } else if (point2.getX() - point1.getX() == 1) {
            System.out.println("Некорректный ввод. Введите корректное значение.");
            inputValue(valuesInSquare);

        } else if (point1.getX() < 0 || point1.getY() < 0
                || point2.getX() < 0 || point2.getY() < 0) {
            System.out.println("Некорректный ввод. Введите корректное значение.");
            inputValue(valuesInSquare);

        } else if (point1.getX() > 98 || point1.getY() > 98
                || point2.getX() > 100 || point2.getY() > 100) {
            System.out.println("Некорректный ввод. Введите корректное значение.");
            inputValue(valuesInSquare);
        }


        for (int i = point1.getX() + 1; i < point2.getX(); i++) {
            for (int j = point1.getY() + 1; j < point2.getY(); j++) {

                valuesInSquare.add(new Point(i, j));
            }
        }
    }
}

