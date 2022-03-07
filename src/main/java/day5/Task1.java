package day5;

public class Task1 {
    public static void main(String[] args) {

        Car tesla = new Car();

        tesla.setModel("X");
        tesla.setColor("White");
        tesla.setYearOfRelease(2015);

        System.out.println(tesla.getModel());
        System.out.println(tesla.getColor());
        System.out.println(tesla.getYearOfRelease());
    }
}

class Car {
    private String model;
    private String color;
    private int yearOfRelease;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
}

