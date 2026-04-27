package multiFeatureTasks.hospital;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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

    public void saveToFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        List<String> lists = people.stream()
                .map(this::personToString)
                        .toList();
        Files.write(path, lists, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void loadFromFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts[0].equals("DOCTOR")){
                String firstName = parts[1];
                String lastName = parts[2];
                String salary = parts[3];
                String bonus = parts[4];
                people.add(new Doctor(firstName, lastName,Double.parseDouble(salary), Double.parseDouble(bonus)));
            }else {
                String firstName = parts[1];
                String lastName = parts[2];
                String salary = parts[3];
                String overtime = parts[4];
                people.add(new Nurse(firstName, lastName, Double.parseDouble(salary), Integer.parseInt(overtime)));
            }
        }
    }

    private String personToString(Person p) {
        if ( p instanceof Doctor){
            return "DOCTOR" + ";" + p.getFirstName() + ";" + p.getLastName() + ";" + p.getSalary() + ";" + ((Doctor) p).getBonus();
        }else if (p instanceof Nurse){
            return "NURSE" + ";" + p.getFirstName() + ";" + p.getLastName() + ";" + p.getSalary() + ";" + ((Nurse) p).getOvertime();
        }
        return null;
    }





}



