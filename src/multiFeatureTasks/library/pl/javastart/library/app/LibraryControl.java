package multiFeatureTasks.library.pl.javastart.library.app;

import multiFeatureTasks.library.pl.javastart.library.exception.DataExportException;
import multiFeatureTasks.library.pl.javastart.library.exception.DataImportException;
import multiFeatureTasks.library.pl.javastart.library.exception.InvalidDataException;
import multiFeatureTasks.library.pl.javastart.library.exception.NoSuchOptionException;
import multiFeatureTasks.library.pl.javastart.library.io.ConsolePrinter;
import multiFeatureTasks.library.pl.javastart.library.io.DataReader;
import multiFeatureTasks.library.pl.javastart.library.io.file.FileManager;
import multiFeatureTasks.library.pl.javastart.library.io.file.FileManagerBuilder;
import multiFeatureTasks.library.pl.javastart.library.model.Book;
import multiFeatureTasks.library.pl.javastart.library.model.Library;
import multiFeatureTasks.library.pl.javastart.library.model.LibraryUser;
import multiFeatureTasks.library.pl.javastart.library.model.Magazine;
import multiFeatureTasks.library.pl.javastart.library.model.comparator.AlphabeticalTitleComparator;

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
                case EXIT -> exit();
                default -> System.out.println("Nie ma takiej opcji, wprowadź ponownie");
            }
        }while (option != Option.EXIT);
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
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie można dodac kolejnej publikacji");
        }
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addPublication(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyc książki, niepoprawne dane");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie można dodac kolejnej publikacji");
        }
    }

    private void printMagazines() {
        printer.printMagazines(library.getSortedPublications(new AlphabeticalTitleComparator()));
    }

    private void printBooks() {
        printer.printBooks(library.getSortedPublications(new AlphabeticalTitleComparator()));
    }

    private void printUsers() {
        printer.printUser(library.getSortedUsers(new Comparator<LibraryUser>() {
            @Override
            public int compare(LibraryUser u1, LibraryUser u2) {
                return u1.getLastName().compareToIgnoreCase(u2.getLastName());
            }
        }));
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
        PRINT_BOOKS(3, " Wyświetlenie dostępnych książek"),
        PRINT_MAGAZINES(4, "Wyświetlenie dostępnych magazynów"),
        DELETE_BOOK(5, "Usuń książkę"),
        DELETE_MAGAZINE(6, "Usuń magazyn");


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
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id " + option);
            }
        }
    }





}
