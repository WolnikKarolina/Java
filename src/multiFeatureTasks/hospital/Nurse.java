package multiFeatureTasks.hospital;

public class Nurse extends Person{
    private int overtime;

    public Nurse(String firstName, String lastName, double salary, int overtime) {
        super(firstName, lastName, salary);
        this.overtime = overtime;
    }

    public Nurse(String firstName, String lastName, double salary) {
        super(firstName, lastName, salary);

    }

    public int getOvertime() {
        return overtime;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "overtime=" + overtime +
                '}';
    }

    @Override
    public String getInfo() {
        return getFirstName() +", " + getLastName() + ", wypłata: " + getSalary() +", nadgodziny: " + overtime;
    }

    @Override
    public double getPay() {
        return getSalary();
    }

}
