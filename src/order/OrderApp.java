package order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OrderApp {
    static void main() {

        List<Order> orders = new ArrayList<>();

        orders.add(new Order(1, 100.0, BigDecimal.valueOf(0.10))); // rabat 10%
        orders.add(new Order(2, 50.0, BigDecimal.valueOf(0) ));                       // brak rabatu
        orders.add(new Order(3, 200.0, BigDecimal.valueOf(0.15))); // rabat 15%
        orders.add(new Order(4, 75.0, BigDecimal.valueOf(0)));                       // brak rabatu
        orders.add(new Order(5, 150.0, BigDecimal.valueOf(0.05))); // rabat 5%
        orders.add(new Order(6, 120.0, BigDecimal.valueOf(0.20)));

        double totalOrders = orders.stream()
                .mapToDouble(Order::finalPrice)
                .sum();
        System.out.println("Suma wszystkich zamówień: " + totalOrders);

        Optional<Order> maxOrder = orders.stream()
                .max(Comparator.comparingDouble(Order::finalPrice));
        maxOrder.ifPresent(o -> System.out.println("Najdroższe zamówienie: " + o));

        double sum = orders.stream()
                .mapToDouble(Order::finalPrice)
                .sum();
        double average = sum/orders.size();
        System.out.println("Srednia warość zamówienia to: " + average);

        System.out.println("Zamówinia w klejności rosnącej według finalnej ceny");
        orders.stream()
                .sorted(Comparator.comparingDouble(Order::finalPrice))
                .forEach(System.out::println);

        System.out.println("Zamówienia z rabatem powyżej 10%");
        orders.stream()
                .filter(o -> o.discount().compareTo(BigDecimal.valueOf(0.1)) > 0)
                .forEach(System.out::println);

        System.out.println("Numery zamówień, których cena po rabacie jest większa niż średnia cena wszystkich zamówień");
        orders.stream()
                .filter(o -> o.finalPrice() > average)
                .forEach(o -> System.out.println(o.number()));

        double ddiscountSum = orders.stream()
                .mapToDouble(o -> o.price() - o.finalPrice())
                .sum();
        System.out.println("Suma rabatów: " + ddiscountSum);

        System.out.println("Zamówienia posortowane według ceny końcowej:");
        Stream<Double> sortedByPrice = orders.stream()
                .map(Order::finalPrice)
                .sorted();
        sortedByPrice.forEach(System.out::println);

        System.out.println("Najtańsze zamówienie");
        orders.stream()
                .min(Comparator.comparingDouble(Order::finalPrice))
                .ifPresent(System.out::println);

        boolean allDiscountMoreThan25 = orders.stream()
                .allMatch(o -> o.discount().compareTo(BigDecimal.valueOf(0.25)) < 0);
        System.out.println(" Wszystkie zamówienia mają rabat mniejszy niż 25%: " + allDiscountMoreThan25);

        System.out.println("Zamówienia z rabatem:");
        orders.stream()
                .filter(o -> o.discount().compareTo(BigDecimal.valueOf(0)) > 0)
                .sorted(Comparator.comparing(Order::discount).reversed())
                .forEach(System.out::println);

        System.out.println("Zamówienia, których cena po rabacie jest wieksza niż 100");
        orders.stream()
                .filter(o -> o.finalPrice() > 100.0)
                .forEach(System.out::println);

        System.out.println("Czy istnieje zamowienie z rabatem 20%?");
        boolean discount20 = orders.stream()
                .anyMatch(o -> o.discount().compareTo(BigDecimal.valueOf(0.2)) == 0);
        System.out.println(discount20);

        System.out.println("Czy cena ktoregoś zamówienia po rabacie wynosi 0?");
        boolean zeroPrice = orders.stream()
                .anyMatch(o -> o.finalPrice() == 0);
        System.out.println(zeroPrice);

        System.out.println("Zamówienia droższe od najtańszego");
        sortedByPrice.skip(1)
                        .forEach(System.out::println);

        System.out.println("Czy najdroższe zamówienie ma rabat większy niż 10%");
        boolean discountAbove10
                = orders.stream()
                .max(Comparator.comparingDouble(Order::finalPrice))
                .map(o -> o.discount().compareTo(BigDecimal.valueOf(0.1)) > 0)
                .orElse(false);


    }



}
