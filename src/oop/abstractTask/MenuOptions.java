package oop.abstractTask;

public enum MenuOptions {
    EXIT(7, "Wyjście z programu"),
    ADD(1, "Dodaj pracownika"),
    SHOW_EMPLOYEES(2, "Pokaż wszystkich pracowników"),
    TOTAL_MONTH_SALARY(3, "Pokaż sumę wypłat miesięcznych"),
    TOTAL_YEAR_SALARY (4, "Pokaż sumę rocznych wypłat"),
    SORTED_MONTHLY_PAYMENTS(5, "Pokaż posortowane wypłaty miesięczne"),
    SORTED_YEARLY_PAYMENTS(6, "Pokaż posortowane wypłaty roczne");

    final int number;
    final String description;

    MenuOptions(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOptions fromInt (int number) {
        for (MenuOptions value : MenuOptions.values()) {
            if (value.getNumber() == number) {
                return value;
            }
        }
        return null;
    }

    public static void showOption(){
        for (MenuOptions value : values()) {
            System.out.println(value.description + " - " + value.number);
        }
    }

}
