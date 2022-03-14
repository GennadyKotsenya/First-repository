package day11.task1;

public class Picker implements Worker{

    private int  salary;
    private boolean isPayed;

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
       salary += 80;
       w.incrementPickedOrders();

    }

    @Override
    public void bonus() {
        if(w.getCountPickedOrders() < 10000){
            System.out.println("Бонус пока не доступен");
            return;
        }
        if (isPayed){
            System.out.println("Бонус уже был выплачен");
            return;
        }

        salary += 70000;
        isPayed = true;

    }
}
