package collection.iterators;

import java.util.Map;
import java.util.TreeMap;

public class PersonApp {
    public static void main(String[] args) {

        Map<String, Person> persons = new TreeMap<>();
        persons.put("Kowalski", new Person("Jan", 49));
        persons.put("Adamska", new Person("Ewelina", 18));
        persons.put("Nowak", new Person("Halina", 52));
        persons.put("Siarzewski", new Person("Marek", 32));
        persons.put("Malinowski", new Person("Jerzy", 25));
        persons.put("Kowlaski", new Person("Mirek", 48));
        persons.put("Biernacki", new Person("Michał", 30));


        for (Map.Entry<String, Person> entry : persons.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            System.out.println(key + ", " + value);
        }

    }
}