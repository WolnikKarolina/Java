package collection.map.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductApp {
    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        lines = readPlik(lines);
        ProductManager pm = new ProductManager();

        addproductFromPlik(lines, pm);

        Scanner sc =new Scanner(System.in);


        System.out.println("Podaj kategorię");
        String choice = sc.nextLine();
        if ( pm.getCategories().contains(choice)){
            System.out.println("Wszystkie produkty z kategorii " + choice);
            pm.showProducts(choice);
            double avg = pm.getAveragePrice(choice);
            System.out.println("Srednia cena produktów z kategorii " + String.format("%.2f", avg));
            System.out.println(pm.getAveragePrice(choice));
            System.out.println("Najtańszy produkt w kategorii " + choice);
            System.out.println(pm.getCheapestProduct(choice));
            System.out.println("Najdroższy produkt w kategorii " + choice);
            System.out.println(pm.getMostExpensiveProduct(choice));
        } else{
            System.out.println("Brak produktów w tej kategroii");
        }

    }

    private static List<String> readPlik(List<String> lines) {
        try{
            Path path = Path.of("src/resources/javazadanie.txt");
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Nie udało się odczytac pliku");
        }
        return lines;
    }

    private static void addproductFromPlik(List<String> lines, ProductManager pm) {
        for (int i =1; i < lines.size(); i++ ) {
            String line = lines.get(i);
            String[] parts = line.split(";");
            String category = parts[0];
            String name = parts[1];
            int price = Integer.parseInt(parts[2]);
            Product product = new Product(category, name, price);
            pm.addProduct(product);
        }
    }


}
