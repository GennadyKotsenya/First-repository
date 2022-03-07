package day5;


public class Task2 {
    public static void main(String[] args) {

        Motorbike honda = new Motorbike("CBR650R", "Red", 2019);

        System.out.println(honda.getModel());
        System.out.println(honda.getColor());
        System.out.println(honda.getYearOfRelease());
    }
}

class Motorbike {

    private String model;
    private String color;
    private int yearOfRelease;

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public Motorbike(String model, String color, int yearOfRelease) {
        this.model = model;
        this.color = color;
        this.yearOfRelease = yearOfRelease;

    }
}