package collection.set;


import java.util.Objects;

public class Participant implements Comparable<Participant>{
    private String name;
    private Priority priority;
    private int order;

    public Participant(String name, Priority priority, int order) {
        this.name = name;
        this.priority = priority;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "{" +
                 name + '\'' +
                ", prioryte: " + priority +
                ", uczestnik nr: " + order +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }


    @Override
    public int compareTo(Participant other) {
        if (other.priority.compareTo(this.priority) == 0){
            return Integer.compare(this.order, other.order);
        }
        return other.priority.compareTo(this.priority);
    }

    public enum Priority{
        LOW,
        MODERATE,
        HIGH,


    }

}
