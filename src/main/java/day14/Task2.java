package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        System.out.println(parseFileToStringList(new File("people.txt")));

    }

    public static List<String> parseFileToStringList(File file) {

        List<String> peoples = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] partList = line.split(" ");

                if (Integer.parseInt(partList[1]) < 0) {
                    throw new IllegalArgumentException("Некорректный входной файл");
                }
                peoples.add(line);
            }
            return peoples;

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
