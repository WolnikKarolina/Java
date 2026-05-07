package multiFeatureTasks.library.pl.javastart.library.app;

import multiFeatureTasks.library.pl.javastart.library.io.DataReader;
import multiFeatureTasks.library.pl.javastart.library.model.Book;

public class LibraryApp {
    static void main(String[] args) {
        final String appname = "Bibiloteka v0.7";


        Book[] books = new Book[1000];
        DataReader dataReader = new DataReader();

        System.out.println(appname);
        System.out.println("Wprowadź pierwszą książkę");
        books[0] = dataReader.readAndCreateBook();
        books[1] = dataReader.readAndCreateBook();
        books[2] = dataReader.readAndCreateBook();

        books[0].printInfo();

        System.out.println("System może przechowywać do " + books.length + " książek");
    }
}
