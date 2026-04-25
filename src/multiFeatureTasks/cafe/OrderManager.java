package multiFeatureTasks.cafe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public boolean addOrder(Order order){
        return orders.add(order);
    }

    public void printOrders(){
        if (orders.isEmpty()){
            throw new IllegalStateException("Brak zamówień");
        } else {
            orders.forEach(System.out::println);
        }
    }

    public double sumOrders(){
        return orders.stream()
                .mapToDouble(Order::price)
                .sum();

    }

    public boolean deleteOrder ( Order order){
        return orders.remove(order);
    }

    public void saveToFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        Files.write(path, orders.stream().map(o-> o.name() + "; "
                + o.price()).toList(), StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void loadFromFile(String fileName) throws IOException {
        Path path = Path.of(fileName);
        if (!Files.exists(path))
            return;
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            String[] parts = line.split("; ");
            String name = parts[0];
            String price = parts[1];
            Order o = new Order(name, Double.parseDouble(price));
            orders.add(o);
        }


    }
}
