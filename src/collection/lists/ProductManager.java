package collection.lists;

import java.util.Comparator;
import java.util.List;

public class ProductManager {

    public static void sortBy(List<Product> products, SortType sortType) {
        Comparator<Product> comparator = switch (sortType){
            case NAME_ASC -> Comparator.comparing(Product::getName);
            case NAME_DESC -> Comparator.comparing(Product::getName).reversed();
            case NETTO_PRICE_ASC -> Comparator.comparingDouble(Product::getNettoPrice).thenComparing(Product::getName);
            case NETTO_PRICE_DESC -> Comparator.comparingDouble(Product::getNettoPrice).reversed().thenComparing(Product::getName);
            case BRUTTO_PRICE_ASC -> Comparator.comparingDouble(Product::getBruttoPrice).thenComparing(Product::getName);
            case BRUTTO_PRICE_DESC -> Comparator.comparingDouble(Product::getBruttoPrice).reversed().thenComparing(Product::getName);
            default -> throw new IllegalArgumentException("Nieprawidłowy parametr");
        };
        products.sort(comparator);
        System.out.println("Sortowanie: "+ sortType);
        showProducts(products);
        System.out.println();
    }


    public static void addProductWithIdShift(int index, List<Product> products, Product product) {
        if (product == null){
            throw new IllegalArgumentException("Produkt nie może być pusty");
        }
        if (product.getName() == null || product.getName().isBlank()) {
            throw new IllegalArgumentException("Nazwa produktu nie może być pusta");
        }
        if (product.getNettoPrice() <= 0 ) {
            throw new IllegalArgumentException("Cena nie może być mniejsza niż 0");
        }
        double brutto = Math.round(product.getNettoPrice() * 1.22 * 100.0) / 100.0;
        product.setBruttoPrice(brutto);
        products.add(index, product );

        for (int i = index + 1; i < products.size(); i++) {
            Product current = products.get(i);
            current.setId(current.getId() + 1);
        }
        System.out.println();
    }

    public static void showOnlyName(List<Product> products) {
        System.out.println("Dostępne produkty: ");
        for (Product product : products) {
            System.out.println(product.getName());
        }
        System.out.println();
    }

    public static void showProducts(List<Product> products) {
        System.out.println("Lista produktów");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println();
    }
}
