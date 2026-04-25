package multiFeatureTasks.cafe;

import java.io.IOException;
import java.util.Scanner;

public class OrderUI {
    private Scanner sc = new Scanner(System.in);
    private OrderManager om = new OrderManager();
    private String fileName = "Orders.csv";



    public void mainLoop() {
        try {
            om.loadFromFile(fileName);
        } catch (IOException e) {
            System.out.println("Nie udało się wczytać pliku: " + e.getMessage());
        }
        while (true) {

            System.out.println("Wybierz opcję: ");
            MenuOption.printMenu();
            MenuOption option = readMenuOption(sc);

            switch (option) {
                case ADD_ORDER -> addOrder(sc, om);
                case PRINT_ORDERS -> printOrders(om);
                case SUM -> sumOrders(om);
                case DELETE_ORDER -> deleteOrders(om);
                case EXIT -> {
                    try {
                        om.saveToFile(fileName);
                    } catch (IOException e) {
                        System.out.println("Nie udało się zapisać pliku: " + e.getMessage());
                    }
                    System.out.println("Bay bay");
                    sc.close();
                    return;
                }
                default -> System.out.println("Niepoprawna opcja");
            }
        }

    }

    private void deleteOrders(OrderManager om) {
        String name = getName(sc);
        double price = getPrice(sc);
        if (om.deleteOrder(new Order(name, price))){
            System.out.println("zamówienie usunięte");
        }else {
            System.out.println("Nie udało się usunąc zamówienia");
        }
    }

    private void sumOrders(OrderManager om) {
        if (om.sumOrders() == 0){
            System.out.println("Brak zamówień ");
            return;
        }
        System.out.println("Suma wszystkich zamówień");
        om.sumOrders();
    }

    private void printOrders(OrderManager om) {
        try {
            System.out.println("Wszystkie zamówienia:");
            om.printOrders();
        }catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }


    private void addOrder(Scanner sc, OrderManager om) {
        String name = getName(sc);
        double price = getPrice(sc);
        if (om.addOrder(new Order(name, price))) {
            System.out.println("Dodano produkt " + name + ", " + price);
        }
    }

    private static double getPrice(Scanner sc) {
        double price;
        while (true) {
            try {
                System.out.println("Podaj cenę");
                price = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("To nie jest liczba");
                sc.nextLine();
            }
        }
        return price;
    }

    private static String getName(Scanner sc) {
        System.out.println("Podaj nazwę");
        String name = sc.nextLine();
        return name;
    }

    private MenuOption readMenuOption(Scanner sc) {
        while (true) {
            try {
                System.out.println("Wprowadz opcję");
                int input = sc.nextInt();
                sc.nextLine();
                return MenuOption.optionFromUser(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Niepoprawna opcja");
            } catch (Exception e) {
                System.out.println("To nie jest liczba");
                sc.nextLine();
            }
        }
    }
}

