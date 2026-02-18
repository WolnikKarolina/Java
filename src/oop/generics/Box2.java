package oop.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Box2 <T> {
    private List<T> items;

    public Box2() {
        this.items = new ArrayList<>();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getLastItem() {
        if (items.isEmpty()) {
            return null;

        } else {
            return items.get(items.size()-1);
        }
    }


    public void printItems(){
        System.out.println("Wszystkie elementy: ");
        for (T item : items) {
            System.out.println(item);

        }

    }

    public List<T> filterItems(Predicate<T> condition) {
        List<T> filtered = new ArrayList<>();
        for (T item : items) {
             if ( condition.test(item)){
                 filtered.add(item);

             }
        }
        return filtered;

    }


}
