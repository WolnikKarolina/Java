package multiFeatureTasks.films;

import java.io.IOException;
import java.util.Scanner;


public class FilmsApp {
    public static final int ADD_MOVIE = 1;
    public static final int WATCHED_MOVIE = 2;
    public static final int MOVIES_FROM_CATEGORY = 3;
    public static final int MOVIES_BY_RATING = 4;
    public static final int MOVIES_TO_WATCH = 5;
    public static final int EXIT = 0;


    public static void main(String[] args) {
        final String filmsToWatch = "FilmsToWatch.csv";
        final String watchedFilms = "WatchedFilms.csv";

        FilmManager fm = new FilmManager();

        Scanner sc = new Scanner(System.in);
        int choice;
        try {
            fm.loadFromFile(filmsToWatch, fm.toWatch);
            fm.loadFromFile(watchedFilms, fm.watched);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        do {
            System.out.println("Wybierz opcję: ");
            System.out.println("Dodaj film - " + ADD_MOVIE);
            System.out.println("Przenieś do obejrzanych - " + WATCHED_MOVIE);
            System.out.println("Wyświetl filmy z danej kategorii - " + MOVIES_FROM_CATEGORY);
            System.out.println("Wyświetl filmy według oceny - " + MOVIES_BY_RATING);
            System.out.println("Wyświetl filmy do obejrzenia - " + MOVIES_TO_WATCH);
            System.out.println("Wyjście - " + EXIT);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addMovie(sc, fm);
                case 2 -> watchedMovie(sc, fm);
                case 3 -> moviesFromCategory(sc, fm);
                case 4 -> moviesByRating(sc, fm);
                case 5 -> moviesToWatch(fm);
                case 0 -> {
                    System.out.println("Bye Bye");
                    try {
                        fm.saveToFile(filmsToWatch, fm.toWatch);
                        fm.saveToFile(watchedFilms, fm.watched);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } while (choice != 0);
    }

    private static void moviesToWatch(FilmManager fm) {
        System.out.println("Filmy do obejrzenia");
        fm.showToWatchFilms();
    }

    private static void moviesByRating(Scanner sc, FilmManager fm) {
        System.out.println("Filmy według oceny: ");
        fm.showMoviesByRating();
    }

    private static void moviesFromCategory(Scanner sc, FilmManager fm) {
        int choice;
        System.out.println("Podaj kategorię filmów które chcesz wyświetlić");
        String category = sc.nextLine();
        choice = getChoice(sc);
        if (choice == 1) {
            fm.showFilmsFromCategory(fm.watched, category);
        } else {
            fm.showFilmsFromCategory(fm.toWatch, category);
        }

    }

    private static int getChoice(Scanner sc) {
        int choice = 0;

        while (true) {
            System.out.println("Obejrzane filmy wybierz 1");
            System.out.println("Filmy do obejrzenia wybierz 2");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1 || choice == 2) {
                    break;
                }
            } else {
                sc.nextLine();
            }
            System.out.println("Niepoprawny wybór, wpisz 1 lub 2");
        }
        return choice;
    }

    private static void watchedMovie(Scanner sc, FilmManager fm) {
        System.out.println("Podaj tytuł filmu który obejrzałeś");
        String title = sc.nextLine();
        fm.moveToWatched(title);
        System.out.println("Przeniesiono film do obejrzanych");
    }

    private static void addMovie(Scanner sc, FilmManager fm) {
        int choice = getChoice(sc);
        System.out.println("Podaj tytuł");
        String title = sc.nextLine();
        System.out.println("Podaj kategorię");
        String category = sc.nextLine();
        System.out.println("Podaj ocenę od 1 - 5");
        int rating = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1 -> fm.addMovie(fm.toWatch, new Film(title, category, rating));
            case 2 -> fm.addMovie(fm.watched, new Film(title, category, rating));
        }
    }
}

