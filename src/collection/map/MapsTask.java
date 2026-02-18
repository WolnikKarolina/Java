package collection.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapsTask {
       public static void main(String[] args) {


           Map<String, Integer> howManyName = new TreeMap<>();
           getMap(readPlik(), howManyName);
           //uzupełniam mapę
           System.out.println("Ilośc imion: " + howManyName.size());

            int maxNameCounter = 0;
            int minNameCounter = Integer.MAX_VALUE;
           for (Integer value : howManyName.values()) {
               if (value > maxNameCounter) maxNameCounter = value;
               if (value < minNameCounter) minNameCounter = value;
           }

           for (Map.Entry<String, Integer> entry : howManyName.entrySet()) {
               if (entry.getValue() == maxNameCounter) {
                   System.out.println("Najczęściej występujące imię to: " + entry.getKey() + ", występuje: " + maxNameCounter + " razy");
               }
               if (entry.getValue() == minNameCounter) {
                   System.out.println("Najrzadziej występuje imie: " + entry.getKey() + ", występuje: " + minNameCounter + " razy");
               }
           }
       }



    private static void getMap(List<String> names, Map<String, Integer> howManyName) {
        for (String name : names) {
            if (!howManyName.containsKey(name)) {
                howManyName.put(name, 1);
            } else {
                int values = howManyName.get(name);
                howManyName.replace(name, ++values);
                // aby nadpisać wartość najpierw ją pobieramy przypisując do zmiennej

            }
        }
    }

    private static List<String> readPlik() {
        Path path = Path.of("src/resources/namespl.txt");
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("błąd odczytu" + e.getMessage());
        }
        return new ArrayList<>();
    }


}
