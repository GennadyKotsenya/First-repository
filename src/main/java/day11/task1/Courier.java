package day11.task1;

public class Courier implements Worker{

    private double salary;
    private boolean isPayed;

    private Warehouse w;
    public Courier (Warehouse w) {
        this.w = w;
    }


    public double getSalary() {
        return salary;
    }

    public boolean isPayed() {
        return isPayed;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "salary = " + salary +
                ", isPayed = " + isPayed +
                '}';
    }

    @Override
    public void doWork() {
        salary += 100;
        w.incrementDeliveredOrders();

    }

    @Override
    public void bonus() {
        if(w.getCountDeliveredOrders()< 10000){
            System.out.println("Бонус пока не доступен");
            return;
        }
        if (isPayed){
            System.out.println("Бонус уже был выплачен");
            return;
        }

        salary += 50000;
        isPayed = true;
    }
}
