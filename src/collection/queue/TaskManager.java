package collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class TaskManager {
    public static void main(String[] args) {


        Queue<Task> tasks = new PriorityQueue<>();
        tasks.offer(new Task("Zrobić zakupy", Task.Priority.MODERATE, 1));
        tasks.offer(new Task("Oddać raport do szefa", Task.Priority.HIGH, 2));
        tasks.offer(new Task("Sprzątnąć biurko", Task.Priority.LOW, 3));
        tasks.offer(new Task("Wysłać maile do klientów", Task.Priority.HIGH, 4));
        tasks.offer(new Task("Umówic wizytę u dentysty", Task.Priority.MODERATE, 5));
        tasks.offer(new Task("Przygotowac prezentację", Task.Priority.HIGH, 6));
        tasks.offer(new Task("Odrobić zadania domowe", Task.Priority.LOW, 7));

        System.out.println(tasks.peek());
        System.out.println(tasks.poll());
        System.out.println(tasks.poll());

        while (!tasks.isEmpty()){
            System.out.println(tasks.poll());
        }

        // System.out.println(tasks.peek());
        // zwróci null bo kolejka jest pusta ale nie wyrzuci błędu
    }



}
