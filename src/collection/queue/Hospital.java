package collection.queue;

import java.util.*;

public class Hospital {
    public static void main(String[] args) {

        //część zadania ze zwykła listą
        Queue<String> patients = new LinkedList<>();
        patients.offer("Karolina Wolnik");
        patients.offer("Basia Jankowska");
        patients.offer("Aneta Borkowska");
        patients.offer("Katarzyna Nowak");
        patients.offer("Anna Majewska");
        System.out.println();

        System.out.println("Lista pacientów: ");
        System.out.println(patients);
        System.out.println("Pierwszy pacient: " + patients.peek());
        System.out.println("kolejny pacjent: " + patients.poll());
        System.out.println("kolejny pacjent: " + patients.poll());
        System.out.println("Obecna lista pacientów: ");
        System.out.println(patients);
        System.out.println();

        Queue<Patient> vipPatients = new PriorityQueue<>(Comparator.comparingInt(Patient::getPriority));

        vipPatients.offer(new Patient("Magda Nowakowska", 5));
        vipPatients.offer(new Patient("Kaisa Adamska", 2));
        vipPatients.offer(new Patient("Michał Konieczny", 1));
        vipPatients.offer(new Patient("Adam Nowak", 4));

        for (Patient vipPatient : vipPatients) {
            System.out.println(vipPatient);
        }
        // pętla for nie wyświetla kolejności pacjentów a kolejnośc dodania
        // do wyświetlenia pacjentów w kolejności priorytetu poll()
        System.out.println("Pierwszy pacjent: " + vipPatients.poll());
        System.out.println("Kolejny pacjent: " + vipPatients.poll());
        System.out.println();
        System.out.println("Pozostali pacjenci");
        while (!vipPatients.isEmpty()) {
            System.out.println(vipPatients.poll());
        }


    }

}
