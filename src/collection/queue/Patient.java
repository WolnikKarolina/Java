package collection.queue;
// zrobiłam zadanie ze wykłej kolejki nastepnie dodałam odpowiednia pola żeby poćwiczyć PriorityQueue
public class Patient {
    private String name;
    private int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return  name +
                ", priorytet=" + priority
                ;
    }
}
