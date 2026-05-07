package multiFeatureTasks.library.pl.javastart.library.app;

import multiFeatureTasks.library.pl.javastart.library.io.DataReader;
import multiFeatureTasks.library.pl.javastart.library.model.Book;
import multiFeatureTasks.library.pl.javastart.library.model.Library;
import multiFeatureTasks.library.pl.javastart.library.model.Magazine;

import static multiFeatureTasks.library.pl.javastart.library.app.Option.*;

public class LibraryControl {



    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop(){
        Option option;
        do {
            printOptions();
            option = Option.createFromInt(dataReader.getInt());
            switch (option){
                case ADD_BOOK -> addBook();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_BOOKS -> printBooks();
                case PRINT_MAGAZINES -> printMagazines();
                case EXIT -> exit();
                default -> System.out.println("Nie ma takiej opcji, wprowadź ponownie");
            }
        }while (option != EXIT);
    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.AddMagazine(magazine);
    }

    private void exit() {
        System.out.println("Koniec programu");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        for (Option option : values()) {
            System.out.println(option);
        }
    }


}
