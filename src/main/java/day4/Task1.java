package day4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(10);

        System.out.println(Arrays.toString(array));

        System.out.println("Длина массива: " + array.length);

        int counter8 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 8)
                counter8++;
        }
        System.out.println("Количество чисел больше 8: " + counter8);


        int counter1 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1)
                counter1++;
        }
        System.out.println("Количество цифер равных 1: " + counter1);


        int anEvenNumberCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                anEvenNumberCount++;
        }
        System.out.println("Количество четных чисел: " + anEvenNumberCount);


        int oddNumberCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0)
                oddNumberCount++;
        }
        System.out.println("Количество нечетных чисел: " + oddNumberCount);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Сумма всех элементов массива: " + sum);
    }
}
