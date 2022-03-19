package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {

        File file1 = new File("src/main/resources/file1.txt");
        Random random = new Random();
        PrintWriter pw1 = new PrintWriter(file1);

        for (int i = 0; i < 1000; i++) {
            pw1.println(random.nextInt(101));
        }
        pw1.close();

        Scanner scanner = new Scanner(file1);
        File file2 = new File("src/main/resources/file2.txt");
        PrintWriter pw2 = new PrintWriter(file2);

        int sum = 0;
        double counter = 0;

        while (scanner.hasNextLine()) {
            sum += Integer.parseInt(scanner.nextLine());
            counter++;

            if (counter == 20) {
                pw2.println(sum / counter);

                counter = 0;
                sum = 0;
            }
        }
        pw2.close();

        printResult(file2);
    }

    public static void printResult(File file) {

        try {
            Scanner scanner = new Scanner(file);
            double sumDoubleNumbers = 0;
            while (scanner.hasNextLine()) {
                sumDoubleNumbers += Double.parseDouble(scanner.nextLine());
            }
            int sumIntNumbers = (int) sumDoubleNumbers;

            System.out.println(sumDoubleNumbers);
            System.out.println(sumIntNumbers);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}

