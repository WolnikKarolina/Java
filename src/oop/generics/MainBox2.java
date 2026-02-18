package oop.generics;

import java.util.List;

public class MainBox2 {
    public static void main(String[] args) {


    Box2<String> products = new Box2<>();
    products.addItem("mleko");
    products.addItem("masło");
    System.out.println("Ostatni element: " + products.getLastItem());
    products.printItems();

    Box2<Integer> volume = new Box2<>();
    volume.addItem(1);
    volume.addItem(15);
    volume.addItem(133);
    System.out.println("Ostatni element: " + volume.getLastItem());
    volume.printItems();

    List<Integer> filtered = volume.filterItems(x -> x > 10);
        System.out.println(" Liczby spełniające warunek: " + filtered);
    }

}
