package day4;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {

        Random random = new Random();

        int[][] matrix = new int[12][8];
        for (int i = 0; i < matrix.length; i++ ) {

            for (int r = 0; r < matrix[i].length; r++)
            matrix[i][r] = random.nextInt(50);

        }
        System.out.println(Arrays.toString(matrix));

        int maxSum = 0;
        int maxSumIdx = 0;
        for (int i = 0; i < matrix.length; i++){
            int sum = 0;
            for (int j = 0; j < matrix[i] .length; j++){
                sum += matrix[i][j];

            }
            if (sum >= maxSum) {
                maxSum = sum;
                maxSumIdx = i;
            }
        }

        System.out.println(maxSumIdx);
    }
}
