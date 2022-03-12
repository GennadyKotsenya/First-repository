package day7;

public class Task1 {
    public static void main(String[] args) {

        Airplane airplane1 = new Airplane("Boeing1",2005,36,41500);
        Airplane airplane2 = new Airplane("Boeing2",2006,38,41550);

        Airplane.compareAirplanes(airplane1,airplane2);
    }
}
