package tasks;

import java.util.List;

public class TaskApp {
    static void main() {


        Task t1 = new Task("Nauczyć się Stream", Status.NEW);
        Task t2 = new Task("Napisać projekt", Status.IN_PROGRESS);
        Task t3 = new Task("Oddać zadanie", Status.DONE);

        List<Task> tasks = List.of(t1, t2, t3);
        tasks.stream()
                .filter(t -> t.status().isActive())
                .forEach(t -> System.out.println(t.title() + " -> " + t.status()));
    }
}
