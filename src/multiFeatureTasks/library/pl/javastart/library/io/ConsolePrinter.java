package multiFeatureTasks.library.pl.javastart.library.io;

import multiFeatureTasks.library.pl.javastart.library.model.Book;
import multiFeatureTasks.library.pl.javastart.library.model.Magazine;
import multiFeatureTasks.library.pl.javastart.library.model.Publication;

public class ConsolePrinter {
    public void printBooks(Publication[] publications) {
        int counter = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.toString());
                counter++;
            }
        }
        if ( counter == 0) {
            System.out.println("Brak książek w bibliotece");
        }
    }

    public void printLine(String text) {
        System.out.println(text);

    }

    public void printMagazines(Publication[] publications) {
        int counter = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                printLine(publication.toString());
                counter++;
            }
        }
        if ( counter == 0) {
            System.out.println("Brak książek w bibliotece");
        }
    }
}
