package stream.task1;

import java.util.*;

public class PersonApp {
    public static void main(String[] args) {


        List<Person> people = List.of(
                new Person("Alice", 23, "Warsaw"),
                new Person("Bob", 17, "Krakow"),
                new Person("Charlie", 30, "Warsaw"),
                new Person("Diana", 20, "Gdansk"),
                new Person("Eve", 16, "Krakow"),
                new Person("Frank", 25, "Gdansk"),
                new Person("Grace", 19, "Warsaw")
        );

        Map<String, List<Person>> peopleByCity = new TreeMap<>();
        people.forEach(person -> peopleByCity.computeIfAbsent(person.getCity(), k -> new ArrayList<>()).add(person));

        peopleByCity.forEach((city, persons) -> {
            persons.sort(Comparator.comparing(Person::getAge).reversed());
            System.out.print(city + ": ");
            persons.forEach(p -> System.out.print(p.getName() + " "));
            System.out.println();

        });







        List<String> sortedPeople = people.stream()
                .filter(n -> n.age > 18)
                .sorted(Comparator.comparing(Person::getName).reversed())
                .map(Person::getName)
                .toList();

        sortedPeople.forEach(System.out::println);
        }


    }

