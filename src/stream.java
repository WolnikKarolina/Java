import java.util.Comparator;
import java.util.List;

public class stream {
    public static void main(String[] args) {


        // wypisz Stringa i jego długość
        List<String> words = List.of("a", "bb", "ccc");
        words.stream().map(n -> n + " - " + n.length()).forEach(System.out::println);
        System.out.println("zad1");

        //wypisz liczby parzyste w kolejności malejącej
        List<Integer> numbers = List.of(3, 6, 1, 8, 2, 10);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("zad2");

        //wypisz długość słów ktore maja wiecej niz 3 litery
        List<String> words2 = List.of("java", "is", "cool", "very");
        words2.stream()
                .map(String::length)
                .filter(n -> n > 3)
                .forEach(System.out::println);
        System.out.println("zad3");

        //Weź tylko liczby większe niż 3 (filter)
        //Pomnóż każdą przez 2
        //Posortuj malejąco
        //Użyj peek do wypisania pośrednich wyników
        //Na końcu policz, ile elementów jest w wyniku
        List<Integer> numbers3 = List.of(5, 2, 8, 1, 6);
        long count = numbers3.stream()
                .filter(n -> n > 3)
                .map(n -> n * 2)
                .sorted(Comparator.reverseOrder())
                .peek(System.out::println)
                .count();
        System.out.println(count);
        System.out.println("zad4");

        // Wypisz długości napisów,które zawierają literę a, w kolejności rosnącej,
        List<String> words3 = List.of("stream", "java", "api", "code");
        words3.stream()
                .filter(n -> n.contains("a") || n.length() > 5)
                .map(String::length)
                .sorted()
                .forEach(System.out::println);
        System.out.println("zad5");

        // liczby wieksze od 3 podnies do kwadratu i wypisz wieksze niz 20 w kolejnosci malejacej, zlicz je
        List<Integer> numbers4 = List.of(3, 7, 2, 9, 4);
        long count1 = numbers4.stream()
                .filter(n -> n > 3)
                .map(n -> n * n)
                .sorted(Comparator.reverseOrder())
                .filter(n -> n > 20)
                .count();
        System.out.println(count1);
        System.out.println("zad6");



    }
}
