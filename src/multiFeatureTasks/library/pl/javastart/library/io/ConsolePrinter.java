package multiFeatureTasks.library.pl.javastart.library.io;

import multiFeatureTasks.library.pl.javastart.library.model.Book;
import multiFeatureTasks.library.pl.javastart.library.model.LibraryUser;
import multiFeatureTasks.library.pl.javastart.library.model.Magazine;
import multiFeatureTasks.library.pl.javastart.library.model.Publication;

import java.util.Collection;

public class ConsolePrinter {

    public void printUser(Collection<LibraryUser> users) {
        for (LibraryUser user : users) {
            printLine(user.toString());
        }
    }

    public void printBooks(Collection<Publication> publications) {
        int counter = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.toString());
                counter++;
            }
        }
        if ( counter == 0) {
            printLine("Brak książek w bibliotece");
        }
    }

    public void printMagazines(Collection<Publication> publications) {
        int counter = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                printLine(publication.toString());
                counter++;
            }
        }
        if ( counter == 0) {
            printLine("Brak książek w bibliotece");
        }
    }

    public void printLine(String text) {
        System.out.println(text);

    }
}
