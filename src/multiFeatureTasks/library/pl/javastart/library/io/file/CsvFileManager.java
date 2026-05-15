package multiFeatureTasks.library.pl.javastart.library.io.file;

import multiFeatureTasks.library.pl.javastart.library.exception.DataExportException;
import multiFeatureTasks.library.pl.javastart.library.exception.DataImportException;
import multiFeatureTasks.library.pl.javastart.library.exception.InvalidDataException;
import multiFeatureTasks.library.pl.javastart.library.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.List;

public class CsvFileManager implements FileManager{
    private static final String PUBLICATION_FILE_NAME = "Library.csv";
    private static final String USERS_FILE_NAME = "Library_users.csv";

    @Override
    public Library importData() {
        Library library = new Library();
        importPublications(library);
        importUsers(library);
        return library;
    }

    @Override
    public void exportData(Library library) {
        exportPublications(library);
        exportUsers(library);
    }

    private void exportUsers(Library library) {
        Collection<LibraryUser> users = library.getUsers().values();
        exportToCsv(users, USERS_FILE_NAME);

    }

    private void exportPublications(Library library) {
        Collection<Publication> publications = library.getPublications().values();
        exportToCsv(publications, PUBLICATION_FILE_NAME);
    }

    private <T extends CsvConvertible> void exportToCsv(Collection<T> collection, String fileName) {
        Path path = Path.of(fileName);
        List<String> lines = collection.stream()
                .map(T::toCsv)
                .toList();
        try {
            Files.write(path, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + fileName);
        }
    }

    private void importUsers(Library library) {
        Path path = Path.of(USERS_FILE_NAME);
        try {
            List<String> lines = Files.readAllLines(path);
            lines.stream()
                    .map(this::createUserFromString)
                    .forEach(library::addUser);
        } catch (IOException e) {
            throw new DataImportException("Błąd odczytu pliku " + USERS_FILE_NAME);
        }
    }

    private void importPublications(Library library) {
        Path path = Path.of(PUBLICATION_FILE_NAME);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            bufferedReader.lines()
                    .map(this::createObjectFromString)
                    .forEach(library::addPublication);
        }catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku " + PUBLICATION_FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd odczytu pliku " + PUBLICATION_FILE_NAME);
        }
    }

    private LibraryUser createUserFromString(String csvText) {
        String[] split = csvText.split(";");
        String firstname = split[0];
        String lastName = split[1];
        String pesel = split[2];
        return new LibraryUser(firstname, lastName, pesel);
    }

    private Publication createObjectFromString(String csvText) {
        String[] split = csvText.split(";");
        String type = split[0];
        if (Book.TYPE.equals(type)) {
            return createBook(split);
        } else if (Magazine.TYPE.equals(type)) {
            return createMagazine(split);
        }
        throw new InvalidDataException("Nieznany typ publikacji: " + type);
    }

    private Publication createMagazine(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        int month = Integer.valueOf(data[4]);
        int day = Integer.valueOf(data[5]);
        String language = data[6];
        return new Magazine(title, publisher, year, month, day, language);

    }

    private Publication createBook(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        String author = data[4];
        int pages = Integer.valueOf(data[5]);
        String isbn = data[6];
        return new Book(title, publisher,  year, author, pages,  isbn);
    }


}
