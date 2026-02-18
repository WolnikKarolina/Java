package collection.restaurationTask;

public class Table {
    private int number;
    private boolean free;

    public Table(int number, boolean free) {
        this.number = number;
        this.free = free;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Stolik " +
                "number: " + number + " "+
                (free ? "wolny" : "zajęty") ;
    }
}
