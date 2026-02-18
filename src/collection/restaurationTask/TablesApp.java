package collection.restaurationTask;

public class TablesApp {
    public static void main(String[] args) {
        TableManager tm = new TableManager();
        tm.showAllTables();
        tm.doReservationFreeTable();
        tm.doReservationTheTable(1);
        tm.showFreeTables();
        tm.doReservationTheTable(5);
        tm.releaseReservation(5);
        tm.showOccupiedTables();
    }
}
