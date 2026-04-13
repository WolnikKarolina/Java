package multiFeatureTasks.cafe;

public enum MenuOption {
    ADD_ORDER(1),
    PRINT_ORDERS(2),
    SUM(3),
    DELETE_ORDER(4),
    EXIT(0);

    private final int option;

    MenuOption(int option) {
        this.option = option;
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
            System.out.println( value + " - " + value.option);

        }
    }
}
