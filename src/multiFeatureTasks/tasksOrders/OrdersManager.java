package multiFeatureTasks.tasksOrders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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

    public void saveToFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        List<String> lists = orders.stream()
                .map(o -> o.getCustomer() + ";" + o.getValue() + ";" + o.getStatus() + ";" + o.getId())
                .toList();
        Files.write(path, lists, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void loadToFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            String[] parts = line.split(";");
            String customer = parts[0];
            String value = parts[1];
            String status = parts[2];
            String id = parts[3];
            orders.add(Order.fromFile(customer, Double.parseDouble(value), Status.valueOf(status), Integer.parseInt(id)));

        }
        int max = orders.stream().mapToInt(multiFeatureTasks.tasksOrders.Order::getId).max().orElse(0);
        Order.setNextId(max);
    }

    public void orderFromId(int id){
        orders.stream()
                .filter(o -> o.getId() == id)
                .forEach(System.out::println);

    }




}



