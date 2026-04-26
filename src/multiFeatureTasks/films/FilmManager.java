package multiFeatureTasks.films;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class FilmManager {

    Set<Film> toWatch = new HashSet<>();
    Set<Film> watched = new HashSet<>();

    public void addMovie(Set<Film> set, Film film) {
        if (set.add(film)) {
            System.out.println("Film dodano");
        } else {
            System.out.println("Film już istnieje");
        }
    }

    public void moveToWatched(String filmTitle) {
        Iterator<Film> iterator = toWatch.iterator();
        while (iterator.hasNext()) {
            Film film = iterator.next();
            if (film.title().equals(filmTitle)) {
                watched.add(film);
                iterator.remove();
            }
        }
    }

    public void showFilmsFromCategory ( Set<Film> set, String category) {
        List<Film> films = set.stream()
                .filter(f -> f.category().equalsIgnoreCase(category))
                .toList();
        if ( films.isEmpty()) {
            System.out.println("Brak filmów w tej kategorii");
        } else {
            films.forEach(System.out::println);
        }
    }

    public void showMoviesByRating() {
        System.out.println("--- Obejrzane filmy ---");
        watched.stream()
                .sorted(Comparator.comparingInt(Film::rating).reversed())
                .forEach(System.out::println);
        System.out.println("--- Filmy do obejrzenia ---");
        toWatch.stream()
                .sorted(Comparator.comparingInt(Film::rating).reversed())
                .forEach(System.out::println);
    }

    public void showToWatchFilms() {
        toWatch.forEach(System.out::println);
    }

    public void saveToFile(String filename, Set<Film> films) throws IOException {
        Path path = Path.of(filename);
        List<String> lists = films.stream()
                        .map(f -> f.title() + ";" + f.category() + ";" + f.rating()).toList();
        Files.write(path, lists, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }


    public void loadFromFile(String fileName, Set<Film> films) throws IOException {
        Path path = Path.of(fileName);
        if (!Files.exists(path))
            return;
        List<String> lists = Files.readAllLines(path);
        for (String list : lists) {
            String[] parts = list.split(";");
            String title = parts[0];
            String category = parts[1];
            String rating = parts[2];
            films.add(new Film(title, category, Integer.parseInt(rating)));
        }
    }
}
