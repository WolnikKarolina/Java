package collection.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaMiniTasks {
    public static void main(String[] args) {

        List<String> names = List.of("Ala", "Ola", "Ewa", "Kasia");
        names.forEach(System.out::print);

        Random r = new Random();
        List<Integer> numbers = new ArrayList<>();
        Supplier<Integer> num = () -> r.nextInt(100);
        for (int i = 0; i < 5; i++) {
            numbers.add(num.get());
        }
        numbers.forEach(n -> System.out.println(n + " "));

        Iterator<Integer> it = numbers.iterator();
        Predicate<Integer> isEven = n -> n % 2 == 0;
        while (it.hasNext()){
            int number = it.next();
            if (isEven.test(number)){
                it.remove();
            }
        }

        numbers.forEach(n -> System.out.println("Liczba: " + n));

        Predicate<Integer> moreThan5 = n -> n > 5;
        numbers.forEach(n -> {
            if (moreThan5.test(n)) {
            System.out.println(n);}
        });

        Function<Integer, String> square = t -> "Kwadrat liczby" + t + "to " + (t * t);
        numbers.forEach(n -> System.out.println(square.apply(n)));



    }
}
