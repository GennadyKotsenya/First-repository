package day6;


public class Motorbike {

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

    public void info() {
        System.out.println("Это мотоцикл");
    }

    public int yearDifference(int inputYear) {
        return Math.abs(inputYear - yearOfRelease);

    }
}