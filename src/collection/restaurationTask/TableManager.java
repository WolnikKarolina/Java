package collection.restaurationTask;

import java.util.HashMap;
import java.util.Map;

public class TableManager {
    static final int MAX_TABLES = 10;

    Map<Integer, Table> tables = new HashMap<>();

    public TableManager() {
        for (int i = 1; i <= MAX_TABLES ; i++) {
            tables.put(i, new Table(i,true));
        }
    }

    public void doReservationFreeTable(){
        for (Table value : tables.values()) {
            if (value.isFree()){
                value.setFree(false);
                System.out.println("Zarezerwowano stolik nr " + value.getNumber());
                return;
            }
        }
        System.out.println("Brak wolnych stolików");
        System.out.println();
    }

    public void doReservationTheTable(int tableNumber){
        Table t = tables.get(tableNumber);
        if ( t == null){
            System.out.println("Nie ma stolika o numerze " + tableNumber);
            return;
        }
        if ( !t.isFree()){
            System.out.println("Stolik o numerze " + tableNumber + " jest już zarezerwowany");
            return;
        }
        t.setFree(false);
        System.out.println("Zarezerwowano stolik numer " + tableNumber);
        System.out.println();
    }

    public void releaseReservation ( int tableNumber) {
        Table t = tables.get(tableNumber);
        if (t == null){
            System.out.println(" Nie ma stolik o numerze " + tableNumber);
            return;
        }
        t.setFree(true);
        System.out.println("Stolik " + tableNumber + " został zwolniony");
        System.out.println();
    }

    public void showAllTables (){
        System.out.println("Wszystkie stoliki: ");
        for (Table value : tables.values()) {
            System.out.println(value + "; ");
        }
        System.out.println();
    }

    public void showFreeTables() {
        System.out.println("Wolne stoliki: ");
        for (Table value : tables.values()) {
            if ( value.isFree()){
                System.out.println(value + "; ");
            }
        }
        System.out.println();
    }

    public void showOccupiedTables() {
        System.out.println("Zajęte stoliki: ");
        for (Table value : tables.values()) {
            if (!value.isFree()){
                System.out.println(value + "; ");
            }

        }
        System.out.println();
    }
}
