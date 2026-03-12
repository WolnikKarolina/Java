package tasks;

public class Main {
    static void main() {


        Status current = Status.IN_PROGRESS;
        System.out.println("Status: " + current.name());
        System.out.println("Czy aktywny: " + current.isActive());

    }
}

enum Status {
    NEW (true),
    IN_PROGRESS (true),
    DONE (false);

    boolean active;

    Status(boolean active) {
        this.active = active;
    }



    public boolean isActive() {
        return active;
    }



}
