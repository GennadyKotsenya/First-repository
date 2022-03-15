package day12.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {

        MusicBand musicBand1 = new MusicBand("Band1", 1998);
        MusicBand musicBand2 = new MusicBand("Band2", 1978);
        MusicBand musicBand3 = new MusicBand("Band3", 1989);
        MusicBand musicBand4 = new MusicBand("Band4", 2007);
        MusicBand musicBand5 = new MusicBand("Band5", 2018);
        MusicBand musicBand6 = new MusicBand("Band6", 1998);
        MusicBand musicBand7 = new MusicBand("Band7", 1997);
        MusicBand musicBand8 = new MusicBand("Band8", 1993);
        MusicBand musicBand9 = new MusicBand("Band9", 2004);
        MusicBand musicBand10 = new MusicBand("Band10", 2010);

        List<MusicBand> musicBands = new ArrayList<>();
        musicBands.add(musicBand1);
        musicBands.add(musicBand2);
        musicBands.add(musicBand3);
        musicBands.add(musicBand4);
        musicBands.add(musicBand5);
        musicBands.add(musicBand6);
        musicBands.add(musicBand7);
        musicBands.add(musicBand8);
        musicBands.add(musicBand9);
        musicBands.add(musicBand10);

        System.out.println(musicBands);

        Collections.shuffle(musicBands);

        System.out.println(groupsAfter2000(musicBands));
    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> musicBands) {
        List<MusicBand> newList = new ArrayList<>();
        for (MusicBand band : musicBands) {
            if (band.getYear() > 2000) {
                newList.add(band);
            }
        }
        return newList;
    }
}

