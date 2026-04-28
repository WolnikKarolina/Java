package oop.abstractTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeesManager {
    List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void showAllEmployees() {
        employees.forEach(System.out::println);
    }

    public double showMonthlySalaryFromAll(){
        return employees.stream()
                .mapToDouble(Employee::calculateMonthlySalary)
                .sum();
    }

    public double showYearlySalaryFromAll() {
        return employees.stream()
                .mapToDouble(Employee::calculateYearlySalary)
                .sum();
    }

    public void showSortedMonthlySalaries() {
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::calculateMonthlySalary))
                .forEach(System.out::println);
    }

    public void showSortedYearlySalaries() {
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::calculateYearlySalary))
                .forEach(System.out::println);
    }

    public void saveToFile ( String fileName) throws IOException {
        Path path = Path.of(fileName);
        List<String> lists = employees.stream()
                .map(this::PersonToSring)
                .toList();
        Files.write(path, lists, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void loadFromFile ( String fileName) throws IOException {
        Path path = Path.of(fileName);
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts[0].equals("Full Time Employee")){
                String firstName = parts[1];
                String lastName = parts[2];
                String monthlySalary = parts[3];
                employees.add(new FullTimeEmployee(firstName, lastName, Double.parseDouble(monthlySalary)));
            } else {
                String firstName = parts[1];
                String lastName = parts[2];
                String hour = parts[3];
                String hourlyRate = parts[4];
                employees.add(new PartTimeEmployee(firstName, lastName, Double.parseDouble(hour), Double.parseDouble(hourlyRate)));
            }

        }
    }

    private String PersonToSring(Employee e) {
        if ( e instanceof FullTimeEmployee ) {
            return "Full Time Employee" + ";" + e.getFirstName() + ";" + e.getLastName() + ";" + ((FullTimeEmployee) e).getMonthlySalary();
        } else if ( e instanceof PartTimeEmployee) {
            return "Part Time Employee" + ";" + e.getFirstName() + ";" + e.getLastName() + ";" + ((PartTimeEmployee) e).getHour() + ";" + ((PartTimeEmployee) e).getHourlyRate();
        }
        return null;
    }


}
