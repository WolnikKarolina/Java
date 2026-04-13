package multiFeatureTasks.cafe;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    List<Order> orders = new ArrayList<>();

    public boolean addOrder(Order order){
        return orders.add(order);
    }

    public void printOrders(){
        if (orders.isEmpty()){
            System.out.println("Brak zamówień");
        } else {
            orders.forEach(System.out::println);
        }
    }

    public double sumOrders(){
        double sum = 0;
        if (orders.isEmpty()){
            System.out.println("Brak zamówień");
            return 0;
        } else {
            sum = orders.stream()
                    .mapToDouble(Order::price)
                    .sum();
        }
        return sum;
    }

    public boolean deleteOrder ( Order order){
        if ( orders.remove(order)){
            return true;
        } else {
            System.out.println("Podane zamówienie nie istnieje");
            return false;
        }
    }
}
