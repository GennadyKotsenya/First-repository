package day8;

public class Task1 {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        String numbers = "";
        for (int i = 0; i <= 20000; i++)
            numbers += i + " ";
        System.out.println(numbers);

        long stopTime = System.currentTimeMillis();

        System.out.println("Длительность работы, в мс.: "
                + (stopTime - startTime));


        long startTime2 = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i <= 20000; i++)
            sb.append(i).append(" ");

        System.out.println(sb);

        long stopTime2 = System.currentTimeMillis();

        System.out.println("Длительность работы, в мс.: "
                + (stopTime2 - startTime2));
    }
}
