package collection.iterators;

public class Person {
    final private String firstName;
    final private int age;

    public Person(String firstName, int age) {
        this.firstName = firstName;

        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return  firstName + ", " + age;

    }
}
