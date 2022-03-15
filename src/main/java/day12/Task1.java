package day12;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Lada");
        list.add("BMW");
        list.add("Audi");
        list.add("Tesla");
        list.add("Mercedes");
        System.out.println(list);

        list.add(3, "Ford");
        list.remove(0);
        System.out.println(list);
    }
}
