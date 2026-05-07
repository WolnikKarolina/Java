package multiFeatureTasks.library.pl.javastart.library.app;

public enum Option {
    EXIT(0, "Wyjście z programu"),
    ADD_BOOK(1, "Dodanie książki"),
    ADD_MAGAZINE(2, "Dodanie magazynu"),
    PRINT_BOOKS(3, " Wyświetlenie dostępnych książek"),
    PRINT_MAGAZINES(4, "Wyświetlenie dostępnych magazynów");

    private int value;
    private String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    static Option createFromInt(int option){
        return Option.values()[option];
    }
}
