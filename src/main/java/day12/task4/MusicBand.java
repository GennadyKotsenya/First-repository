package day12.task4;

import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<String>members;

    public MusicBand(String name, int year, List<String> members) {
        this.name = name;
        this.year = year;
        this.members = members;
    }

    public int getYear() {
        return year;
    }

    public List<String> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    public static void transferMembers(MusicBand a, MusicBand b){

        b.getMembers().addAll(a.getMembers());
        a.getMembers().clear();
    }

    public void printMembers(){
        System.out.println(this.members);
    }
}
