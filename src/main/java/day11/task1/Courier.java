package day11.task1;

public class Courier implements Worker {

    private double salary;
    private boolean isPayed;
    final int SALARY_AMOUNT = 100;
    final int BONUS_AMOUNT = 50000;
    final int DELIVERED_ORDERS = 10000;

    private Warehouse w;

    public Courier(Warehouse w) {
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
        salary += SALARY_AMOUNT;
        w.incrementDeliveredOrders();

    }

    @Override
    public void bonus() {
        if (w.getCountDeliveredOrders() < DELIVERED_ORDERS) {
            System.out.println("Бонус пока не доступен");
            return;
        }
        if (isPayed) {
            System.out.println("Бонус уже был выплачен");
            return;
        }

        salary += BONUS_AMOUNT;
        isPayed = true;
    }
}
