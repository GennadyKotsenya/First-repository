package day6;

public class Task2 {
    public static void main(String[] args) {

        Airplane airplane = new Airplane("Boeing", 1968, 35, 41410);
        airplane.info();

        Airplane airplane1 = new Airplane("Boeing2",1969,36,41500);
        airplane1.fillUp(20000);
        airplane1.info();

        airplane1.setManufacturer("Boeing3");
        airplane1.setYear(1970);
        airplane1.setLength(37);
        airplane1.fillUp(1000);
        airplane1.fillUp(300);
        airplane1.info();
    }
}

class Airplane {
    private String manufacturer;
    private int year;
    private int length;
    private int weight;
    private int fuel = 0;

    public Airplane(String manufacturer, int year, int length, int weight) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.length = length;
        this.weight = weight;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    void info(){
        System.out.printf("Изготовитель: %s, год выпуска: %d, длина: %d," +
                " вес: %d ,количество топлива с баке: %d%n"
                ,manufacturer,year,length,weight,fuel);
    }

    public void fillUp(int n) {
        fuel += n;
    }

}