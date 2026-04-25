package exception.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {
    private static final int COUNT = 1;
    private static final int EXIT = 2;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Wykonj obliczenia - " + COUNT);
            System.out.println("Wyjście z programu - " + EXIT);
            choice = sc.nextInt();
            switch (choice) {
                case COUNT -> {
                    InputData data = readAB(sc);
                    Calculator.calculate(data.a(), data.b(), data.operator());
                }
                case EXIT -> System.out.println("Koniec progrramu");
                default -> System.out.println("Niepoprawny wybór");
            }
        }while (choice != EXIT);
        sc.close();
    }


    public record InputData(double a , double b, String operator){}

    private static InputData readAB(Scanner sc) {
        double a;
        double b;
        String operator;
        while (true){
            try {
                System.out.println("Podaj pierwszą liczbę");
                a = sc.nextDouble();
                sc.nextLine();
                System.out.println("Podaj drugą liczbę");
                b = sc.nextDouble();
                sc.nextLine();
                System.out.println("Podaj operator matematyczny");
                operator = sc.nextLine();
                break;
            }catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawne dane");
                sc.nextLine();
            }
        }
        return new InputData(a, b, operator);
    }


}
