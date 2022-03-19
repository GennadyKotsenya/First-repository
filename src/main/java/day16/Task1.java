package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        printResult(new File("numbers.txt"));

    }

    public static void printResult(File file) {

        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");


            double sum = 0;
            double averageValue = 0;

            for (String number : numbers) {
                sum += Integer.parseInt(number);
                averageValue = sum / numbers.length;
            }

            System.out.println(averageValue);
            System.out.printf("%.3f", averageValue);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

