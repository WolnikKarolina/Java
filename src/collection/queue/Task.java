package collection.queue;

public class Task implements Comparable<Task>{
    private String name;
    private Priority priority;
    private int order;

    public Task(String name, Priority priority, int order) {
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
        return "Task{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", order=" + order +
                '}';
    }

    @Override
    public int compareTo(Task other) {
        if (other.priority.compareTo(this.priority) == 0) {
            return Integer.compare(this.order, other.order);
        }
            return other.priority.compareTo(this.priority);



    }



    public enum Priority {LOW , MODERATE, HIGH}


}
