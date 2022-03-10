package day7;

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

    public int getLength() {
        return length;
    }

    void info(){
        System.out.printf("Изготовитель: %s, год выпуска: %d, длина: %d," +
                " вес: %d ,количество топлива с баке: %d%n"
                ,manufacturer,year,length,weight,fuel);
    }

    public void fillUp(int n) {
        fuel += n;
    }

    public static void compareAirplanes(Airplane airplane1, Airplane airplane2){

        if (airplane1.getLength()> airplane2.length){
            System.out.println("Первый самолёт длиннее");
        } else if (airplane2.getLength()> airplane1.length){
            System.out.println("Второй самолёт длинее");
        } else  {
            System.out.println("Длины самолётов равны");
        }
    }
}