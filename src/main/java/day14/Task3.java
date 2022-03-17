package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        System.out.println(parseFileToObjList(new File("people.txt")));

    }

    public static List<Person> parseFileToObjList(File file) {

        List<Person> peoples = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] partList = line.split(" ");

                if (Integer.parseInt(partList[1]) < 0)
                    throw new IllegalArgumentException();

                Person person = new Person(partList[0],
                        Integer.parseInt(partList[1]));

                peoples.add(person);
            }
            return peoples;

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректный входной файл");
        }
        return null;
    }
}
