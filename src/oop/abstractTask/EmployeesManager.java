package oop.abstractTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeesManager implements Serializable {
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



}
