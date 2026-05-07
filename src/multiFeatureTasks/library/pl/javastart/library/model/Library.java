package multiFeatureTasks.library.pl.javastart.library.model;

public class Library {

    private static final int MAX_BOOKS = 1000;
    private static final int MAX_MAGAZINES = 1000;
    Book[] books = new Book[MAX_BOOKS];
    Magazine[] magazines = new Magazine[MAX_MAGAZINES];
    private int booksNumber;
    private int magazinesNumbers;

    public void addBook(Book book){
        if ( booksNumber < MAX_BOOKS) {
            books[booksNumber] = book;
            booksNumber++;
        }else {
            System.out.println("Maksymalna liczba książek została osiągnięta");
        }
    }

    public void AddMagazine(Magazine magazine){
        if ( magazinesNumbers < MAX_MAGAZINES) {
            magazines[magazinesNumbers] = magazine;
            magazinesNumbers++;
        } else {
            System.out.println("Maksymalna liczba magazynów została osiągnięta");
        }
    }

    public void printBooks() {
        if (booksNumber == 0) {
            System.out.println("Brak książek w bibliotece");
        }
        for (int i = 0; i < booksNumber; i++) {
            books[i].printInfo();
        }
    }

    public void printMagazines() {
        if ( magazinesNumbers == 0) {
            System.out.println("Brak magazynów w bibliotece");
        }
        for (int i = 0; i < magazinesNumbers; i++) {
            magazines[i].printInfo();
        }
    }




}
