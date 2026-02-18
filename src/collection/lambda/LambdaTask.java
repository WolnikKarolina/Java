package collection.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTask {
    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        generateRandomNumbers(random, numbers);

        System.out.println("Lista przed usunięciem liczb parzystych");
        printNumbers(numbers);

        removeIsEven(numbers);
        System.out.println("Lista po usunięciu liczb parzystych");
        printNumbers(numbers);

    }

    private static void removeIsEven(List<Integer> numbers) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()){
            int num = it.next();
            if ( isEven.test(num)){
                it.remove();

            }
        }
    }

    private static void printNumbers(List<Integer> numbers) {
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void generateRandomNumbers(Random random, List<Integer> numbers) {
        Supplier<Integer> number = () -> random.nextInt(100);
        for (int i = 0; i < 10; i++) {
            numbers.add(number.get());
        }
    }

}
