package multiFeatureTasks.hospital;

public class Doctor extends Person {
    private double bonus;

    public Doctor(String firstName, String lastName, double salary, double bonus) {
        super(firstName, lastName, salary);
        this.bonus = bonus;
    }

    public Doctor(String firstName, String lastName, double salary) {
        super(firstName, lastName, salary);

    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "bonus=" + bonus +
                '}';
    }

    @Override
    public String getInfo() {
        return getFirstName() +", " + getLastName() + ", wypłata: " + getSalary() + ", bonus: " + bonus;
    }

    @Override
    public double getPay() {
        return getSalary() + getBonus();
    }

}
