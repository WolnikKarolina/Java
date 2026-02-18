package stream.task2;

public class Transaction {
    private String customer;
    private String region;
    private double amount;
    private boolean fraud;

    public Transaction(String customer, String region, double amount, boolean fraud) {
        this.customer = customer;
        this.region = region;
        this.amount = amount;
        this.fraud = fraud;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isFraud() {
        return fraud;
    }

    public void setFraud(boolean fraud) {
        this.fraud = fraud;
    }
}
