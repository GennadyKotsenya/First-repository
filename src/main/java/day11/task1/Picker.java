package day11.task1;

public class Picker implements Worker {

    private int salary;
    private boolean isPayed;
    final int SALARY_AMOUNT = 80;
    final int BONUS_AMOUNT = 70000;
    final int DELIVERED_ORDERS = 10000;

    private Warehouse w;

    public Picker(Warehouse w) {
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
        return "Picker{" +
                "salary = " + salary +
                ", isPayed = " + isPayed +
                '}';
    }

    @Override
    public void doWork() {
        salary += SALARY_AMOUNT;
        w.incrementPickedOrders();

    }

    @Override
    public void bonus() {
        if (w.getCountPickedOrders() < DELIVERED_ORDERS) {
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
