package collection.set.tasks;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;




public class ProductManager {

        private final static int ADD_PRODUCT = 1;
        private final static int EXIT = 2;
        private final static int OVERWRIT = 1;
        private static final int IGNORED = 2;

        private final Set<Product> products = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        void loop() {
                int choice = 0;
                do {
                        try {
                                showOptions(ADD_PRODUCT, "Dodaj produkt", EXIT, "Koniec programu");
                                choice = sc.nextInt();
                                sc.nextLine();
                                switch (choice) {
                                        case ADD_PRODUCT -> addProduct();
                                        case EXIT -> theEnd();
                                        default -> System.out.println("niepoprawna opcja. Wybierz 1 lub 2");
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Błąd: wpisz liczbę");
                                sc.nextLine();
                        }
                } while (choice != EXIT);

        }

        private void showOptions(int key1, String desc1, int key2, String desc2) {
                System.out.println("Wybierz opcję: ");
                System.out.println(key1 + " - " + desc1);
                System.out.println(key2 + " - " + desc2);
        }


        private void theEnd() {
                System.out.println("Wszystkie produkty: ");
                for (Product product : products) {
                        System.out.println(product);
                }
                System.out.println("Do widzenia");
                sc.close();
        }

        private void addProduct() {

                int choice;
                Product newProduct = getProduct();
                if (products.contains(newProduct)) {
                        System.out.println("Produkt o tej nazwie już istnieje");
                        showOptions(OVERWRIT, "Nadpisz produkt", IGNORED, "Nie nadpisuj");
                        choice = sc.nextInt();
                        sc.nextLine();
                        try {
                                if (choice == OVERWRIT) {
                                        products.remove(newProduct);
                                        products.add(newProduct);
                                        System.out.println("Zaktualizowano produkt");

                                } else {
                                        System.out.println("Zostawiono wcześniejszą wersję produktu");

                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Niepoprawne dane, spróbuj jeszcze raz");
                                sc.nextLine();
                        }
                } else {
                        products.add(newProduct);
                }


        }
        // dodałam pętle retry -> powtarze się do czasu kiedy nie zwróci poprawnego produktu
        private Product getProduct() {
                while (true) {
                        try {
                                System.out.println("Podaj nazwę");
                                String name = sc.nextLine();
                                System.out.println("Podaj cenę");
                                Double price = sc.nextDouble();
                            return new Product(name, price);
                        } catch (InputMismatchException e) {
                                System.out.println("Podano niewłaściwe dane");
                                sc.nextLine();
                        }
                }
        }
}