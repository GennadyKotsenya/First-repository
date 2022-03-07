package day3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            double divisible = scanner.nextDouble();
            double divisor = scanner.nextDouble();
            if (divisor == 0)
                break;

            System.out.println(divisible / divisor);
        }
    }
}
