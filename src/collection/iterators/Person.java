package collection.iterators;

public record Person(String firstName, int age) {

    @Override
    public String toString() {
        return firstName + ", " + age;

    }
}
