package oop.abstractTask;

public enum MenuOptions {
    EXIT(0),
    ADD(1),
    SHOW_EMPLOYEES(2),
    TOTAL_MONTH_SALARY(3),
    TOTAL_YEAR_SALARY (4),
    SORTED_MONTHLY_PAYMENTS(5),
    SORTED_YEARLY_PAYMENTS(6);

    final int number;

    MenuOptions(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static MenuOptions fromInt ( int number) {
        for (MenuOptions value : MenuOptions.values()) {
            if (value.getNumber() == number) {
                return value;
            }
        }
        return null;
    }

}
