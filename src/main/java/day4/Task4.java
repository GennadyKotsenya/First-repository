package day4;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {

        int[] array = new int[100];
        Random randNum = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = randNum.nextInt(10000);
        }
        System.out.println(Arrays.toString(array));

        int maxSum = 0;
        int maxSumIdx = 0;
        for (int i = 0; i < array.length - 2; i++) {
            int sum = 0;
            for (int j = i; j < i + 3; j++) {
                sum += array[j];
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxSumIdx = i;
            }
        }
        System.out.println(maxSumIdx);
        System.out.println(maxSum);
    }
}
