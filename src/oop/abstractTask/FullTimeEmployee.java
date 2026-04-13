package oop.abstractTask;

public class FullTimeEmployee extends Employee {
private static final double BONUS = 0.05;
private double monthlySalary;

    public FullTimeEmployee(String firstName, String lastName, double monthlySalary) {
        super(firstName, lastName);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    double calculateMonthlySalary() {
        return monthlySalary;
    }

    @Override
    double calculateYearlySalary() {
        double salaryPerYear = monthlySalary * 12;
        return salaryPerYear += BONUS;
    }


}
