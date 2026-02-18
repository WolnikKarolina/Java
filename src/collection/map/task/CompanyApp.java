package collection.map.task;

import java.util.InputMismatchException;
import java.util.Scanner;



public class CompanyApp {


        private static final int ADD_EMPLOYEE = 1;
        private static final int SHOW_EMPLOYEE = 2;
        private static final int EXIT = 3;

    private static final Scanner sc = new Scanner(System.in);
    private static final Company company = new Company();

    public static void main(String[] args) {


        int choice;

            do {
                try{

                    System.out.println("Wybierz opcję: ");
                    System.out.println("Dodaj pracownika:  " + ADD_EMPLOYEE);
                    System.out.println("Wyświetl informacje o pracowniku: " + SHOW_EMPLOYEE);
                    System.out.println("Wyjście z programu: " + EXIT);
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1 -> add();
                        case 2 -> show();
                        case 3 -> exit();
                        default -> System.out.println("Wybierz poprawną opcję");
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Wprowadziłeś niepoprawne dane");
                    sc.nextLine();
                    choice = 0; // żeby pętla się nie kończyła
                }

            } while (choice != EXIT);




    }

    private static void exit() {
        System.out.println("Koniec programu - Do widzenia!");
        sc.close();
    }

    private static void show() {
        System.out.println("Podaj imię pracownika którego szukasz");
        String firstName = sc.nextLine().trim();
        System.out.println("Podaj nazwisko pracownika którego szukasz");
        String lastName = sc.nextLine().trim();
        Employee employee = company.getEmployee(firstName, lastName);
        if ( employee != null){
            System.out.println(employee);
        } else {
            System.out.println("Nie znaleziono pracownika");
        }

    }

    private static void add() {
        String firstName;
        System.out.println("Dodawanie nowego pracownika: ");
        do {
            System.out.println("Podaj imię");
            firstName = sc.nextLine();
            if (firstName.isEmpty()) {
                System.out.println("Imię nie może być puste");
            }
        } while (firstName.isEmpty());
        String lastName;
        do {
            System.out.println("Podaj nazwisko");
            lastName = sc.nextLine();
            if (lastName.isEmpty()) {
                System.out.println("Nazwisko nie może być puste");
            }
        } while (lastName.isEmpty());
        while (true) {
            try {
                System.out.println("Podaj wynagordzenie");
                double salary = sc.nextDouble();
                sc.nextLine();
                Employee employee = new Employee(firstName, lastName, salary);
                company.addEmployee(employee);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawne dane");
                sc.nextLine();
            }

        }
    }




}
