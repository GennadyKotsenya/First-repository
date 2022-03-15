package day12.task4;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {

        List<String> members1 = new ArrayList<>();
        members1.add("A.D.");
        members1.add("S.D.");
        members1.add("F.D.");
        members1.add("M.D.");
        MusicBand band1 = new MusicBand("Music Band", 2005, members1);

        List<String> members2 = new ArrayList<>();
        members2.add("Z.R.");
        members2.add("B.R.");
        members2.add("V.R.");
        MusicBand band2 = new MusicBand("Music Band2", 2009, members2);

        band1.printMembers();
        band2.printMembers();

        MusicBand.transferMembers(band1,band2);
        band1.printMembers();
        band2.printMembers();
    }
}
