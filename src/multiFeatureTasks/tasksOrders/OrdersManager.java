package multiFeatureTasks.tasksOrders;

import java.util.ArrayList;
import java.util.List;

public class OrdersManager {

    List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void countActive() {
        double count = (double)orders.stream()
                .filter( o -> o.getStatus().isActive())
                .count();
        System.out.println("Ilośc aktywnych zamówień: " + count);
    }

    public void showActive() {
        orders.stream()
                .filter(o -> o.getStatus().isActive())
                .forEach(System.out::println);
    }

    public void showBig() {
        orders.stream()
                .filter(Order::isBig)
                .forEach(System.out::println);
    }

    public void totalActiveValue() {
        double sum = orders.stream()
                .filter(o -> o.getStatus().isActive())
                .mapToDouble(Order::getValue)
                .sum();
        System.out.println("Łączna wartość aktywnych zamówień: " + sum);
    }

    public void showAllOrders() {
        orders.stream()
                .forEach(System.out::println);
    }

    public void takeOrder( int id) {

        orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        o -> {
                            o.takeOrder();
                            System.out.println("Rozpoczynam realizację zamówienia nr: " + id);
                        },
                        () -> System.out.println("Nie znaleziono zamówienia o nr: " + id)
                ) ;
    };

    public void ready (int id) {
        orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        o -> {
                            o.completeOrder();
                            System.out.println("Zrealizowano zamówienie nr: " + id);
                        },
                        () -> System.out.println("Nie znaleziono zamówienia o nr: " + id)
                );
    }

    public void showReadyOrders() {
        System.out.println("---Zrealizowane zamówienia:");
        long count = orders.stream()
                .filter(o -> o.getStatus() == Status.ZREALIZOWANE)
                .peek(System.out::println)
                .count();
        System.out.println("Łącznie zrealizowanych zamówień: " + count);

    }




}



