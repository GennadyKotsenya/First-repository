package day12.task5;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {

        List<MusicArtist> members1 = new ArrayList<>();
        members1.add(new MusicArtist("A.D.", 23));
        members1.add(new MusicArtist("S.D.", 45));
        members1.add(new MusicArtist("F.D.", 32));
        members1.add(new MusicArtist("M.D.", 21));
        MusicBand band1 = new MusicBand("Music Band1", 2015, members1);

        List<MusicArtist> members2 = new ArrayList<>();
        members2.add(new MusicArtist("Z.R.", 24));
        members2.add(new MusicArtist("B.R.", 31));
        members2.add(new MusicArtist("V.R.", 27));
        MusicBand band2 = new MusicBand("Music Band2", 2019, members2);

        band1.printMembers();
        band2.printMembers();

        MusicBand.transferMembers(band1, band2);
        band1.printMembers();
        band2.printMembers();
    }
}
