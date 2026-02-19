package collection.map;

import java.util.*;
import java.util.stream.Collectors;

public class task3 {
    public static void main(String[] args) {


        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple",
                "carrot", "cucumber", "lettuce", "broccoli", "banana",
                "pear", "peach", "plum", "apple", "cabbage", "carrot",
                "orange", "kiwi", "kale", "lemon", "lime", "grape", "grapefruit");

        System.out.println("Pogrupuj słowa według długości znaków");
        Map<Integer, List<String>> wordLength = new TreeMap<>();
        words.forEach(word -> wordLength.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word));
        wordLength.entrySet()
                        .forEach(entry -> {
                                int howManyLetters = entry.getKey();
                                String word = String.valueOf(entry.getValue());
                            System.out.println(howManyLetters + ": " + word);

                        });

        System.out.println("Liczba unikalnych liter w słowie");
        Map<String, Long> uniqueLetters = words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.chars().distinct().count(),
                        (a,b) -> a,
                        TreeMap::new));
        System.out.println();
       /* wcześniejsze rozwiązanie
       Map<String, Integer> uniqueLetter = new TreeMap<>();
        words.forEach(word -> {
            HashSet<Character> letters = new HashSet<>();
            for (char c : word.toCharArray()) {
                letters.add(c);
            }
            int uniqueLettersCounter = letters.size();
            uniqueLetter.put(word, uniqueLettersCounter);
        });
        uniqueLetter.entrySet().forEach(entry -> {
            String word = entry.getKey();
            Integer howManyUniqueLetters = entry.getValue();
            System.out.println(word + ": " + howManyUniqueLetters);
        });*/



        System.out.println("Wyświetl najdłuższy wyraz na daną literę");
        Map<Character, String> longestWordByLetter = new TreeMap<>();
        words.forEach(word -> {
            longestWordByLetter.computeIfAbsent(word.charAt(0), k -> word );
            char firstLetter = word.charAt(0);
            String current = longestWordByLetter.get(firstLetter);
            if (word.length() > current.length()) {
                longestWordByLetter.put(firstLetter, word);
            }
        });
        longestWordByLetter
                .entrySet()
                .forEach(entry -> {
                    Character letter = entry.getKey();
                    String word = entry.getValue();
                    System.out.println(letter + "; " + word);
                });
        System.out.println();

        System.out.println("Ile razy występuje dane słowo w liście?");
        Map<String, Integer> wordCount = new HashMap<>();
        words.forEach(word -> {
            wordCount.computeIfAbsent(word, k -> 0);
            wordCount.put(word, wordCount.get(word) + 1);

        });
        wordCount.entrySet().forEach(System.out::println);
        System.out.println();

        System.out.println("Słowa na daną literę");
        Map<Character, List<String>> wordsByFirstLetter = new TreeMap<>();
        words.forEach(letter -> wordsByFirstLetter.computeIfAbsent(letter.charAt(0), k -> new ArrayList<>()).add(letter));
        wordsByFirstLetter.entrySet().stream()
                    .forEach(entry -> {
                    Character letter = entry.getKey();
                    List<String> list = entry.getValue();
                    System.out.println(letter + ": " + list);
                });
        System.out.println();



    }
}
