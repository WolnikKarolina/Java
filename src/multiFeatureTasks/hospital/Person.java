package multiFeatureTasks.hospital;

import java.util.Objects;

public abstract class Person {
    private String firstName;
    private String lastName;
    private double salary;

    public Person(String firstName, String lastName, double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Wypłat amusi byc wieksza od 0");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
    public abstract String getInfo();
    public abstract double getPay();
}
