package day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.*;

/**
 * @author Neil Alishev
 */
public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {

        File text = new File("src/main/resources/dushi.txt");
        Scanner scanner = new Scanner(text);
        scanner.useDelimiter("[.,:;()?!\"\\s–]+");
        Map<String, Integer> wordAndCount = new HashMap<>();


        while (scanner.hasNext()) {
            String word = scanner.next();
            if (wordAndCount.containsKey(word)) {
                wordAndCount.put(word, wordAndCount.get(word) + 1);
            } else {
                wordAndCount.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>
                        (wordAndCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {

                return (o2.getValue() - o1.getValue());
            }
        });

        list.subList(100, list.size()).clear();

        System.out.println(list.size());
        System.out.println();


        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

//        Чичиков : 601
    }
}
