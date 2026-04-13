package oop.travleAgencyTask;

public abstract class Service {
    private String name;
    private double netPrice;
    private int minParticipant;
    private int maxParticipant;

    public String getName() {
        return name;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public int getMinParticipant() {
        return minParticipant;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public Service(String name, double netPrice, int minParticipant, int maxParticipant) {
        this.name = name;
        this.netPrice = netPrice;
        this.minParticipant = minParticipant;
        this.maxParticipant = maxParticipant;
    }

    public abstract double calculateGrossPrice();
}
