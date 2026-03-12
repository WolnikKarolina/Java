package multiFeatureTasks.tasksOrders;

public class Order {
    private String customer;
    private double value;
    private Status status;
    private int id;



    private static int nextId = 1;

    static final double BIG_VALUE = 100.0;

    public Order(String customer, double value) {
        this.customer = customer;
        this.value = value;
        this.status = Status.NOWE;
        this.id = nextId++;
    }

    public int getId() {
        return this.id;
    }

    public String getCustomer() {
        return customer;
    }

    public double getValue() {
        return value;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public String getActive() {
        return status.isActive() ? "AKTYWNE" : "NIEAKTYWNE";
    }

    public boolean isBig() {
        return value >= BIG_VALUE;
    }

    public void takeOrder() {
        if (status == Status.NOWE) {
            status = Status.W_TRAKCIE_REALIZACJI;
        } else {
            throw new IllegalArgumentException("To zamówenie nie jest nowe, nie można się podjąc jego realizacji");
        }
    }

    public void completeOrder () {
        if (status == Status.W_TRAKCIE_REALIZACJI) {
            status = Status.ZREALIZOWANE;
        }else {
            throw new IllegalArgumentException("To zamówenie jest nowe i nie może zostać od razu zrealizowane");
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer='" + customer + '\'' +
                ", value=" + value +
                ", status=" + status +
                ", id=" + id +
                '}';
    }


}
