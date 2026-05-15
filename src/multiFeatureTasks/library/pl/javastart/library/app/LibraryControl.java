package multiFeatureTasks.library.pl.javastart.library.app;

import multiFeatureTasks.library.pl.javastart.library.exception.*;
import multiFeatureTasks.library.pl.javastart.library.io.ConsolePrinter;
import multiFeatureTasks.library.pl.javastart.library.io.DataReader;
import multiFeatureTasks.library.pl.javastart.library.io.file.FileManager;
import multiFeatureTasks.library.pl.javastart.library.io.file.FileManagerBuilder;
import multiFeatureTasks.library.pl.javastart.library.model.*;

import java.util.Comparator;
import java.util.InputMismatchException;


public class LibraryControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private FileManager filemanager;
    private Library library;

    public LibraryControl() {
        filemanager = new FileManagerBuilder(printer, dataReader).build();
        try {
            library = filemanager.importData();
            printer.printLine("Zaimportowane dane z pliku");
        }catch (DataImportException | InvalidDataException e) {
            printer.printLine(e.getMessage());
            printer.printLine("Zainicjowano nową bazę");
            library = new Library();
        }
    }

    public void controlLoop(){
        Option option;
        do {
            printOptions();
            option = getOption();
            switch (option){
                case ADD_BOOK -> addBook();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_BOOKS -> printBooks();
                case PRINT_MAGAZINES -> printMagazines();
                case DELETE_BOOK -> deleteBook();
                case DELETE_MAGAZINE -> deleteMagazine();
                case ADD_USER -> addUser();
                case PRINT_USERS -> printUsers();
                case FIND_BOOK -> findBook();
                case EXIT -> exit();
                default -> System.out.println("Nie ma takiej opcji, wprowadź ponownie");
            }
        }while (option != Option.EXIT);
    }

    private void findBook() {
        printer.printLine("Podaj tytuł publikacji");
        String title = dataReader.getString();
        library.findPublicationByTitle(title)
                .map(Publication::toString)
                .ifPresentOrElse(System.out::println, () -> System.out.println("notFoundMessage"));
    }

    private void addUser() {
        LibraryUser libraryUser = dataReader.createLibraryUser();
        try {
            library.addUser(libraryUser);
        }catch (UserAlreadyExistsException e) {
            printer.printLine(e.getMessage());
        }
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        for (Option option : Option.values()) {
            System.out.println(option);
        }
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            }catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", podaj ponownie: ");
            }catch (InputMismatchException ignored) {
                printer.printLine("Wprowadzono wartość, która nie jest liczbą, podaj ponownie: ");
            }
        }
        return option;
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addPublication(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyc książki, niepoprawne dane");
        }
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addPublication(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyc książki, niepoprawne dane");
        }

    }

    private void printMagazines() {
        printer.printMagazines(library.getSortedPublications(
                Comparator.comparing(Publication::getTitle, String.CASE_INSENSITIVE_ORDER)));
    }

    private void printBooks() {
        printer.printBooks(library.getSortedPublications(
               Comparator.comparing(Publication::getTitle, String.CASE_INSENSITIVE_ORDER)));

    }

    private void printUsers() {
        printer.printUser(library.getSortedUsers(
                Comparator.comparing(User::getLastName, String.CASE_INSENSITIVE_ORDER)
        ));
    }

    private void deleteMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            if (library.removePublication(magazine))
                printer.printLine("Usunięto magazyn");
            else
                printer.printLine("Brak wskazanego magazynu");
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utowrzyć magazynu, niepoprawne dane");
        }
    }

    private void deleteBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            if (library.removePublication(book))
                printer.printLine("Usunięto książkę");
            else
                printer.printLine("Brak wskazanej książki");
        }catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć ksiązki, niepoprawne dane");
        }
    }

    private void exit() {
        try {
            filemanager.exportData(library);
            printer.printLine("Export danych do pliku zakończony powodzeniem");
        } catch (DataExportException e) {
            printer.printLine(e.getMessage());
        }
        printer.printLine("Koniec programu");
        dataReader.close();
    }

    private enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BOOK(1, "Dodanie książki"),
        ADD_MAGAZINE(2, "Dodanie magazynu"),
        PRINT_BOOKS(3, "Wyświetlenie dostępnych książek"),
        PRINT_MAGAZINES(4, "Wyświetlenie dostępnych magazynów"),
        DELETE_BOOK(5, "Usuń książkę"),
        DELETE_MAGAZINE(6, "Usuń magazyn"),
        ADD_USER(7, "Dodaj czytelnika"),
        PRINT_USERS(8, "Wyświetl czytelników"),
        FIND_BOOK(9, "Wyszukaj książkę");


        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            for (Option value : Option.values()) {
                if (value.value == option) {
                    return value;
                }
            }
            throw new NoSuchOptionException("Brak opcji o id " + option);
        }



    }





}
