package multiFeatureTasks.garden;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlantApp {
    List<Plant> plants = new ArrayList<>();

    public void addPlant(String name, double maxHeight, boolean blooms) {
        plants.add(new Plant(name, maxHeight, blooms));
    }

    public void showAllPlants() {
        System.out.println(" ---- Wszystkie rośliny: ");
        plants.forEach(p ->
                System.out.println((p.name() +
                        "-> maksymalna wysokość: " + p.maxHeight()) +
                        " kwitnienie: " + (p.bloom() ? "tak" : "nie")));
    }

    public void showBloomPlant() {
        System.out.println(" ---- Kwitnące rośliny: ");
        plants.stream()
                .filter(p -> p.bloom())
                .forEach(p ->
                        System.out.println((p.name() +
                                "-> maksymalna wysokość: " + p.maxHeight()) +
                                " kwitnienie: " + (p.bloom() ? "tak" : "nie")));
    }

    public void highestPlant() {
        plants.stream()
                .max(Comparator.comparingDouble(Plant::maxHeight))
                .ifPresent(p -> System.out.println("Najwyższa roślina: " + p.name() + ", wyskość " + p.maxHeight()));
    }

    public void countBloomPlants() {
        long countBloomPlants = plants.stream()
                .filter(p -> p.bloom())
                .count();
        System.out.println("Ilość kwitnących roślin: " + countBloomPlants);


    }
}
