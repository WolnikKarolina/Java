package multiFeatureTasks.hospital;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;


public class Hospital {
    Set<Person> people = new HashSet<>();

    public void addEmployee(Person person) {
        if (person != null) {
            people.add(person);
        }
        System.out.println("Wprowadź dane");

    }

    public void getInfo() {
        people.stream()
                .map(Person::getInfo)
                .forEach(System.out::println);
    }

    public double payAll(Class<? extends Person> type) {
        return people.stream()
                .filter(type::isInstance)
                .mapToDouble(Person::getPay)
                .sum();
    }


    public double average(Class<? extends Person> type) {
        return people.stream()
                .filter(type::isInstance)
                .mapToDouble(Person::getPay)
                .average()
                .orElse(0);
    }

    public void printSortedByPay() {
        people.stream()
                .sorted(Comparator.comparingDouble(Person::getPay))
                .forEach(p -> System.out.println(p.getInfo() + ", wypłata: " + p.getPay()));
    }


}



