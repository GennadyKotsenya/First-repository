package day4;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {

        int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
        System.out.println(Arrays.toString(array));

        int max = 0;
        for (int element : array) {
            if (element > max)
                max = element;
        }


        System.out.println(max);
        int min = 10000;
        for (int element2 : array) {
            if (element2 < min)
                min = element2;
        }
        System.out.println(min);


        int numb0 = 0;
        for (int element : array) {
            if (element % 10 == 0)
                numb0++;
        }
        System.out.println(numb0);


        int sum = 0;
        for (int element : array) {
            if (element % 10 == 0)
                sum += element;
        }
        System.out.println(sum);
    }
}
