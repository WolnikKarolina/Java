package multiFeatureTasks.cafe;

import java.util.Scanner;

public class OrderUI {
    Scanner sc = new Scanner(System.in);
    MenuOption option;


    public void mainLoop() {
        while(true) {
            System.out.println("Wybierz opcję: ");
            MenuOption.printMenu();
            option = readMenuOption(sc);

            sc.nextLine();
            switch (option) {
                case ADD_ORDER -> addOrder(sc);
                case PRINT_ORDERS -> printOrders();
                case SUM -> sumOrders();
                case DELETE_ORDER -> deleteOrders();
                case EXIT -> {
                    System.out.println("Bay bay");
                    sc.close();
                    return;
                }
                default -> System.out.println("Niepoprawna opcja");
            }
        }

    }

    private MenuOption readMenuOption(Scanner sc) {
        while (true) {
            try {
                System.out.println("Wprowadz opcję");
                int input = sc.nextInt();
                sc.nextLine();
                return MenuOption.optionFromUser(input);
            }catch (IllegalArgumentException e){
                System.out.println("Niepoprawna opcja");
            }catch (Exception e){
                System.out.println("To nie jest liczba");
                sc.nextLine();
            }
    }
}
