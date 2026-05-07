package oop.travleAgencyTask;

public class Car extends Service {
    private int mileLimit = 100;
    private int mileageUsed;
    private boolean available = true;

    public Car(String name, double netPrice, int minParticipant, int maxParticipant) {
        super(name, netPrice, minParticipant, maxParticipant);
    }

    private Car(String name, double netPrice, int minParticipant, int maxParticipant, int mileLimit, int mileageUsed, boolean available) {
        super(name, netPrice, minParticipant, maxParticipant);
        this.mileLimit = mileLimit;
        this.mileageUsed = mileageUsed;
        this.available = available;
    }

    public static Car fromFile(String name, double netPrice, int minParticipant, int maxParticipant, int mileLimit, int mileageUsed, boolean available){
        return new Car(name, netPrice, minParticipant, maxParticipant, mileLimit, mileageUsed, available);
    }

    public int getMileLimit() {
        return mileLimit;
    }

    public int getMileageUsed() {
        return mileageUsed;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        String avalibleText = available ? "tak" : "nie";
        return getName() + ", " + calculateGrossPrice() + ", " + "limit: " + mileLimit + ", " + avalibleText;
    }

    @Override
    public double calculateGrossPrice() {
        return getNetPrice() * 1.23;
    }

    public void rentCar(){
        available = false;

    }

    public double returnCar(int currentMileage, int numberOfDays ){
        int totalTrip = currentMileage - mileageUsed;
        int totalLimit = numberOfDays * mileLimit;
        double supplement = 0;
        if (totalTrip  > totalLimit) {
            supplement = (totalTrip - totalLimit) * 2;
        }

        mileageUsed = currentMileage;
        available = true;
        return supplement;
    }
}
