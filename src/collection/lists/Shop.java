package collection.lists;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "Mleko", 3.5, 4.31));
        products.add(new Product(102, "Chleb", 2.5, 3.08));
        products.add(new Product(103, "Masło", 6.0, 7.38));
        products.add(new Product(104, "Jajka", 5.0, 6.15));
        products.add(new Product(105, "Ser", 8.0, 9.84));
        products.add(new Product(106, "Jogurt", 2.8, 3.44));


        ProductManager.showProducts(products);
        ProductManager.showOnlyName(products);
        Product newProduct = new Product(102, "Mleko sojowe", 4.2);
        ProductManager.addProductWithIdShift(1, products, newProduct ); // na potrzeby zadania zmieniam id produktów, żeby poćwiczyć
        ProductManager.showProducts(products);
        ProductManager.sortBy(products, SortType.NAME_ASC );
        ProductManager.sortBy(products, SortType.NETTO_PRICE_ASC);





    }


}

