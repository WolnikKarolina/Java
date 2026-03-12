package multiFeatureTasks.tasksOrders;

public enum Status {
    NOWE (true),
    W_TRAKCIE_REALIZACJI(true),
    ZREALIZOWANE (false);


    private final boolean active;

    Status(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }




}
