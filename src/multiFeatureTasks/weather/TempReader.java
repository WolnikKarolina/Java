package multiFeatureTasks.weather;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TempReader {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<TempApp.Weather> list = readPlik();
        LocalDate createDate = readDate(sc);
        TempApp.Unit chosenUnit = readUnit(sc);
        list.stream()
                .filter(w -> w.data().equals(createDate))
                .findFirst()
                .ifPresentOrElse(w ->{
                        double min = w.unit().convert(w.minTemp(), chosenUnit);
                        double max = w.unit().convert(w.maxTemp(), chosenUnit);
                    System.out.println("Data: " + w.data());
                    System.out.println("Minimalna temperatura: " + Math.round(min) + " " + chosenUnit.getUnitSight());
                    System.out.println("Maksymalna temperatura: " + Math.round(max) + " " + chosenUnit.getUnitSight());

                }, () -> System.out.println("Brak danych dla tej daty"));
    }

    private static TempApp.Unit readUnit(Scanner sc) {
        while (true) {
            System.out.println("W jakiej jednostce wyświetlić pomiary? C/F");
            String input = sc.nextLine().trim();
            try {
                return TempApp.Unit.fromString(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Nieprawidłowa jednostka! Wpisz C lub F");
            }
        }
    }

    private static LocalDate readDate(Scanner sc) {
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.println("Dane z którego dnia Cię interesują? (format (yyyy-MM-dd)");
            String input = sc.nextLine().trim();
            try {
                return LocalDate.parse(input, datePattern);
            } catch (Exception e) {
                System.out.println("Nieprawidłowy format daty! Spróbuj ponownie");
            }
        }
    }

    public static List<TempApp.Weather> readPlik() {
        Path path = Path.of("src/resources/weather.csv");
        try {
            return Files.readAllLines(path).stream()
                    .map(line -> {
                        try {
                            String[] parts = line.split(";");
                            LocalDate date = LocalDate.parse(parts[0], DateTimeFormatter.ISO_LOCAL_DATE);
                            double minTemp = Double.parseDouble(parts[1]);
                            double maxTemp = Double.parseDouble(parts[2]);
                            TempApp.Unit unit = TempApp.Unit.valueOf(parts[3]);
                            return new TempApp.Weather(date, minTemp, maxTemp, unit);
                        } catch (Exception e) {
                            System.out.println("Błąd parsowania lisni: " + line);
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .toList();
        } catch (IOException e) {
            System.out.println("Błąd" + e.getMessage());
            return new ArrayList<>();
        }

    }
}
