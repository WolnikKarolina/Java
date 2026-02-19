package stream.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Raport {
    public static void main(String[] args) {


        // Zrób raport zawierający tylko niefraudowe operacje powyzej 1000,
        // wyswietl w postaci region i suma transakcji, rosnaco wedlug sumy transakcji
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Anna", "Europe", 1200, false));
        transactions.add(new Transaction("John", "USA", 800, false));
        transactions.add(new Transaction("Maria", "Europe", 5400, false));
        transactions.add(new Transaction("Steve", "USA", 3000, true));
        transactions.add(new Transaction("Kasia", "Asia", 7600, false));
        transactions.add(new Transaction("Tom", "Asia", 400, false));
        transactions.add(new Transaction("Olga", "Europe", 2300, false));
        transactions.add(new Transaction("Mike", "USA", 1500, false));
        transactions.add(new Transaction("Lee", "Asia", 9900, true));
        transactions.add(new Transaction("Eva", "Europe", 2000, false));

        top3(transactions);
        raport(transactions);

    }

    private static void top3(List<Transaction> transactions) {
        Map<String, List<Double>> stat1 =
                transactions.stream()
                                .filter(t -> !t.isFraud() && t.getAmount() > 1000)
                                        .collect(Collectors.groupingBy
                                                (Transaction::getRegion,
                                                        Collectors.mapping(
                                                                Transaction::getAmount,
                                                                Collectors.toList()
                                                        )));
        Map<String, ArrayList<Double>> top3 = stat1.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .limit(3)
                                .collect(Collectors.toCollection(ArrayList::new))
                ));
        top3.forEach((region,amonts) -> {
                    System.out.println("Region: " + region);
                    System.out.println("Top 3 transakcje: " + amonts);
                     System.out.println();
        }
        );
    }


    private static void raport(List<Transaction> transactions) {
        System.out.println("Suma transakcji dla poszczególnych regionów wynosi: ");
        Map<String, Double> result = transactions.stream()
                .filter(t -> !t.isFraud())
                .filter(t -> t.getAmount() > 1000)
                .collect(Collectors.toMap(
                        Transaction::getRegion,
                        Transaction::getAmount,
                        Double::sum,
                        LinkedHashMap::new
                ));
        result.entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .forEach( (entry -> System.out.println(entry.getKey() + " -> suma transakcji: " + entry.getValue())));

    }
}
