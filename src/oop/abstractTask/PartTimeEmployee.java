package oop.abstractTask;

public class PartTimeEmployee extends Employee {
    private double hour;
    private double hourlyRate;

    public PartTimeEmployee(String firstName, String lastName, double hour, double hourlyRate) {
        super(firstName, lastName);
        this.hour = hour;
        this.hourlyRate = hourlyRate;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateMonthlySalary() {
        return hour * hourlyRate;
    }

    @Override
    double calculateYearlySalary() {
        return calculateMonthlySalary() * 12;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
