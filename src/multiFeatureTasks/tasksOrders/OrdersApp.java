package multiFeatureTasks.tasksOrders;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class OrdersApp {
    public static void main() {


        OrdersManager om = new OrdersManager();
        Scanner sc = new Scanner(System.in);
        mainLoop(om, sc);



    }

    private static void mainLoop(OrdersManager om, Scanner sc) {
        final String fileName = "Orders2.csv";
        try {
            om.loadToFile(fileName);
        } catch (IOException e) {
            System.out.println("Odczyt z pliku nie powiódł się");
        }
        boolean running = true;
        while(running){
        System.out.println("Wybierz opcję");
        MenuOptionsOrder.printOption();
        int choice = readNumber(sc);
        MenuOptionsOrder option = MenuOptionsOrder.fromInt(choice);
        switch (option) {
            case ADD_ORDER -> newOrder(om, sc);
            case PRINT_ORDER -> printOrders(om);
            case PRINT_TOTAL_VALUE_ACTIVE -> printTotalActive(om);
            case PRINT_ACTIVE -> printActiveOrers(om);
            case PRINT_BIGGEST -> printBiggestOrder(om);
            case TAKE_ORDER -> startRealize(om, sc);
            case TO_REALIZE -> finishOrder(om, sc);
            case PRINT_REALIZE_ORDER -> printRealizeOrders(om);
            case EXIT -> {
                try {
                    om.saveToFile(fileName);
                } catch (IOException e) {
                    System.out.println("Zapis do pliku nie powiódł się");
                }
                running = false;
            }
            default -> System.out.println("Niepoprawny wybór");
        }
        }
    }

    private static void printRealizeOrders(OrdersManager om) {
        System.out.println("--- Zrealizowane zamówienia ---");
        om.showReadyOrders();
    }

    private static void finishOrder(OrdersManager om, Scanner sc) {
        System.out.println("Podaj nr zamówienia które zostało zrealizowane");
        int number = readNumber(sc);
        om.ready(number);
        System.out.println("Zamównie zrealizowane");
    }

    private static void startRealize(OrdersManager om, Scanner sc) {
        System.out.println(" Podaj numer zamówienia do realizacji");
        int number = readNumber(sc);
        om.takeOrder(number);
        System.out.print("Rozpoczęto realizację zamówienia ");
        om.orderFromId(number);

    }

    private static void printBiggestOrder(OrdersManager om) {
        System.out.println("--- Największe zamówienie ---");
        om.showBig();
    }

    private static void printActiveOrers(OrdersManager om) {
        System.out.println("--- Wszystkie aktywne zamówienia ---");
        om.showActive();
    }

    private static void printTotalActive(OrdersManager om) {
        System.out.println("--- Wartośc aktywnych zamówień ---");
        om.countActive();
    }

    private static void printOrders(OrdersManager om) {
        System.out.println("--- Wszystkie zamówenia ---");
        om.showAllOrders();
    }

    private static void newOrder(OrdersManager om, Scanner sc) {
        System.out.println("Wprowadź zamówienie");
        System.out.println("Nazwa klienta");
        String name = sc.nextLine();
        System.out.println("Podaj wartość zamówienia");
        double value = sc.nextDouble();
        om.addOrder(new Order(name, value));
        System.out.println("Zamówienie dodane");
    }

    private static int readNumber(Scanner sc) {
        System.out.println("Podaj numer");
        while (true){
            try {
                int number = sc.nextInt();
                sc.nextLine();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Wpisz poprawną liczbę");
                }
            }catch (InputMismatchException e){
                System.out.println("Wybierz liczbę");
                sc.nextLine();
            }
        }
    }
}
