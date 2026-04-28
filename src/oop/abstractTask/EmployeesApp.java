package oop.abstractTask;

import java.util.Scanner;

public class EmployeesApp {

    public static void main(String[] args) {


        EmployeesManager manager = new EmployeesManager();
        manager.addEmployee(new FullTimeEmployee("Jan", "Kowalski", 8000));
        manager.addEmployee(new PartTimeEmployee("Adam", "Małysz", 140, 26));
        manager.addEmployee(new PartTimeEmployee("Maciej", "Kowalczyk", 140, 26));
        manager.addEmployee(new PartTimeEmployee("Katarzyna", "Janke", 80, 23));
        manager.addEmployee(new PartTimeEmployee("Majka", "Gorczyca", 120, 29));
        manager.addEmployee(new FullTimeEmployee("Agnieszka", "Adamczewska", 9000));
        manager.addEmployee(new FullTimeEmployee("Jan", "Kowal", 7000));
        manager.addEmployee(new FullTimeEmployee("Jacek", "Michalski", 5000));

        Scanner sc = new Scanner(System.in);
        MenuOptions choice;
        mainLoop(sc, manager);
    }

    public static void mainLoop(Scanner sc, EmployeesManager manager) {
        MenuOptions choice;
        do{
            System.out.println("Wybierz opcję:");
            System.out.println("Dodaj pracownika - 1");
            System.out.println("Pokaż wszystkich pracowników - 2");
            System.out.println("Pokaż sumę wypłat miesięcznych - 3");
            System.out.println("Pokaż sumę wypłat rocznych - 4");
            System.out.println("Pokaż posortowane wypłaty miesięczne - 5");
            System.out.println("Pokaż posortowane wypłaty roczne - 6");
            System.out.println("Wyjście z programu - 0");
            int userInput = (int)readPositiveNumber(sc, "Wpisz numer opcji z menu");
            sc.nextLine();
            choice = MenuOptions.fromInt(userInput);
            if (choice != null) {
                switch (choice) {
                    case ADD -> addNewEmployee(sc, manager);
                    case SHOW_EMPLOYEES -> showEmployees(manager);
                    case TOTAL_MONTH_SALARY -> monthlySalary(manager);
                    case TOTAL_YEAR_SALARY -> yearlySalary(manager);
                    case SORTED_MONTHLY_PAYMENTS -> manager.showSortedMonthlySalaries();
                    case SORTED_YEARLY_PAYMENTS -> manager.showSortedYearlySalaries();
                    case EXIT -> {
                        System.out.println("Bye bye");
                        sc.close();
                    }

                }
            } else {
                System.out.println("Niepoprawny wybór, wpisz liczbą z menu!");
            }
        }while (choice != MenuOptions.EXIT);
    }

    private static void yearlySalary(EmployeesManager manager) {
        System.out.println("Roczna suma wypłat: " + manager.showYearlySalaryFromAll() + "zł");

    }

    private static void monthlySalary(EmployeesManager manager) {
        System.out.println("Miesięczna suma wypłat: " + manager.showMonthlySalaryFromAll() + "zł");
    }


    private static void showEmployees(EmployeesManager manager) {
        System.out.println("Wszyscy pracownicy:");
        manager.showAllEmployees();
    }

    private static double readPositiveNumber(Scanner sc, String prompt) {
        double number;
        do {
            System.out.println(prompt);
            while (!sc.hasNextDouble()) {
                System.out.println("Niepoprawny format, wpisz liczbę");
                sc.next();
            }
            number = sc.nextDouble();
            if (number <= 0) {
                System.out.println("Liczba musi być dodatnia");
            }
        }while (number <= 0);
        return number;
    }

    private static void addNewEmployee(Scanner sc, EmployeesManager manager) {
        System.out.println("Dodaj nowego pracownika: ");
        System.out.println("Podaj imię");
        String firstName = sc.nextLine();
        System.out.println("Podaj nazwisko ");
        String lastName = sc.nextLine();
        int choice = 0;
        while (choice != 1 && choice !=2) {
            choice = (int)readPositiveNumber(sc, "Wybierz: pełen etat - 1/ niepełny etat - 2");
        }
        if (choice == 1) {
            double salary = readPositiveNumber(sc, "Podaj miesięczną pensję");
            manager.addEmployee(new FullTimeEmployee(firstName, lastName, salary));
        } else {
            double hours = readPositiveNumber(sc, "Podaj liczbe godzin");
            double rate = readPositiveNumber( sc, "Podaj stawkę godzinową");
            manager.addEmployee(new PartTimeEmployee(firstName, lastName, hours, rate));
        }
        System.out.println("Dodano pracownika");
    }


}