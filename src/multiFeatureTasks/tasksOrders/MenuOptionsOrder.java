package multiFeatureTasks.tasksOrders;

import javax.swing.*;

public enum MenuOptionsOrder {
    ADD_ORDER(1, "Dodaj zamówienie"),
    PRINT_ORDER(2, "Pokaż wszystkie zamówienia"),
    PRINT_TOTAL_VALUE_ACTIVE(3, "Pokaż wartośc aktywnych zamówień"),
    PRINT_ACTIVE(4, "Pokaż ilość aktywnych zamówień"),
    PRINT_BIGGEST(5, "Pokaż największe zamówinie"),
    TAKE_ORDER(6, "Rozpocznij realizację zamówienia"),
    TO_REALIZE(7, "Zrealizuj zamówienie"),
    PRINT_REALIZE_ORDER(8, "Pokaż zrealizowane zamówienia"),
    EXIT(0, "Wyjście z programu");

    private int number;
    private String description;

    MenuOptionsOrder(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOptionsOrder fromInt(int number){
        for (MenuOptionsOrder value : values()) {
            if (value.number == number){
                return value;
            }
        }
        return null;
    }

    public static void printOption(){
        for (MenuOptionsOrder value : values()) {
            System.out.println(value.getNumber() + " - " + value.description);
        }
    }
}
