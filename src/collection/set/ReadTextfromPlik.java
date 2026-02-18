package collection.set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ReadTextfromPlik {
// odczytać dane z pliku tak żeby były posortowane alfabetycznie tylko od tyłu.
// Zrobię dwa rozwiązania żeby poćwiczyć odczyt z plku
    public static void main(String[] args) {

        //  1 rozwiązanie
        List<String> names = new ArrayList<>();
        Path path = Path.of("src/resources/namespl.txt");
        try {
            names = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TreeSet<String> sortedNames = new TreeSet<>(Comparator.reverseOrder());
        for (String name : names) {
            sortedNames.add(name.trim());
        }
        System.out.println("Rozwiązanie nr 1: Ilość imion: " + sortedNames.size());
        System.out.println("Rozwiązanie nr 1: Pierwszy element: " + sortedNames.first());
        System.out.println("Rozwiązanie nr 1: Ostatni element: " + sortedNames.last());

        // 2 rozwiązanie
        TreeSet<String> sortedNamesBr = new TreeSet<>(Comparator.reverseOrder());
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/namespl.txt"))) {
            String line;
            while ((line = br.readLine()) != null){
                sortedNamesBr.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Rozwiązanie nr 2: Ilość imion: " + sortedNamesBr.size());
        System.out.println("Rozwiązanie nr 2, Pierwszy element: " + sortedNamesBr.first());
        System.out.println("Rozwiązanie nr 2: Ostatni element: " + sortedNamesBr.last());

    }
}
