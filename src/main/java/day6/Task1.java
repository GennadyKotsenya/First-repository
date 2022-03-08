package day6;

public class Task1 {
    public static void main(String[] args) {

        Motorbike motorbike = new Motorbike("CBR650R", "Red", 2019);
        motorbike.info();
        System.out.println(motorbike.yearDifference(2005));

        Car car = new Car();
        car.setModel("X");
        car.setColor("White");
        car.setYearOfRelease(2015);

        car.info();
        System.out.println(car.yearDifference(2030));

    }
}
