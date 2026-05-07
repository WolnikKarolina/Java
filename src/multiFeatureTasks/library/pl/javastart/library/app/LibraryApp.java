package multiFeatureTasks.library.pl.javastart.library.app;

public class LibraryApp {
    private static final String APP_NAME = "Bibiloteka v1.1";

    static void main(String[] args) {


        LibraryControl libControl = new LibraryControl();

        System.out.println(APP_NAME);
        libControl.controlLoop();


    }
}
