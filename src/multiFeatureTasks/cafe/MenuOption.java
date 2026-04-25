package multiFeatureTasks.cafe;

public enum MenuOption {
    ADD_ORDER(1, "Dodaj zamówienie"),
    PRINT_ORDERS(2, "Wyświetl zamówienie"),
    SUM(3, "Suma zamówień"),
    DELETE_ORDER(4, "Usuń zamówienie"),
    EXIT(0, "Wyjście z programu");

    private final int option;
    private final String description;

    MenuOption(int option, String description) {
        this.option = option;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getOption() {
        return option;
    }

    public static MenuOption optionFromUser(int o){
        for (MenuOption value : values()) {
            if ( value.option == o){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid menu option" + o);
    }
    public static void printMenu(){
        for (MenuOption value : MenuOption.values()) {
            System.out.println( value.description + " - " + value.option);

        }
    }
}
