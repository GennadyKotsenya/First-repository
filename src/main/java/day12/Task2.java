package day12;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {

        System.out.println(fillingEvenNumbers(0, 30, 300, 350));

    }

    public static List<Integer> fillingEvenNumbers(
            int numberIn1, int numberOut1, int numberIn2, int numberOut2) {
        List<Integer> list = new ArrayList<>();

        for (int i = numberIn1; i <= numberOut1; i++) {
            if (i % 2 == 0) {
                list.add(i);
            }
        }
        for (int i = numberIn2; i <= numberOut2; i++) {
            if (i % 2 == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
