package multiFeatureTasks.library.pl.javastart.library.model;

public class Library {

    private static final int MAX_PUBLICATIONS = 2000;
    private int publicationsNumber;
    Publication[] publications = new Publication[MAX_PUBLICATIONS];

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        for (int i = 0; i < publicationsNumber; i++) {
            result[i] = publications[i];
        }
        return result;
    }

    private void addPublication(Publication publication) {
        if (publicationsNumber >= MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("Max publications exceeded")
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }

    public void addBook(Book book){
        addPublication(book);
    }

    public void AddMagazine(Magazine magazine){
        addPublication(magazine);
    }






}
