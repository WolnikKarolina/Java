package collection.map.task2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    // wybrałam inne rozwiązanie niż w kursie java żeby poćwiczyć
    Map<String, Set<Product>> products = new HashMap<>();

    public Set<String> getCategories(){
    return products.keySet();

    }

    public void addProduct(Product product){
        products.putIfAbsent(product.getCategory(), new HashSet<>());
        //String category = product.getCategory();
        //Set<Product> set = products.get(category);
        //set.add(product);
        // te wszystkei trzy linie to ta:
        products.get(product.getCategory()).add(product);
    }

    public void showProducts(String category){
        if ( products.get(category)  != null) {
            for (Product product : products.get(category)) {
                System.out.println(product);
            }
        }else {
            System.out.println("Brak produktów w danej kategorii");
        }
    }

    public double getAveragePrice (String category){
        int priceCounter = 0;
        int productsCounter = 0;
        if ( products.get(category)  != null) {
            for (Product product : products.get(category)) {
                priceCounter += product.getPrice();
                productsCounter++;
            }
            if (productsCounter == 0){
                return 0;
            }
        }else {
            return 0;
        }
        return (double) priceCounter / productsCounter;
    }

    public Product getCheapestProduct(String category){
        Product cheapestProduct = null;

        if ( products.get(category)  != null) {
            for (Product product : products.get(category)) {
                if (cheapestProduct == null ){
                    cheapestProduct = product;
                } else if (product.getPrice() < cheapestProduct.getPrice()) {
                    cheapestProduct = product;
                }
            }
        }else {
            return null;
        } return cheapestProduct;
    }

    public Product getMostExpensiveProduct(String category){
        Product mostExpensiveProduct = null;

        if ( products.get(category)  != null) {
            for (Product product : products.get(category)) {
                if (mostExpensiveProduct == null ){
                    mostExpensiveProduct = product;
                } else if (product.getPrice() > mostExpensiveProduct.getPrice()) {
                    mostExpensiveProduct = product;
                }
            }
        }else {
            return null;
        } return mostExpensiveProduct;
    }






}
