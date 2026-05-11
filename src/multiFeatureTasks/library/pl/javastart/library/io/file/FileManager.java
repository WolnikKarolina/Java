package multiFeatureTasks.library.pl.javastart.library.io.file;

import multiFeatureTasks.library.pl.javastart.library.model.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}
