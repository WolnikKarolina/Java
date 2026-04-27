package multiFeatureTasks.hospital;

import java.io.IOException;

public class HospitalApp {
    static void main(String[] args) {

        final String fileName = ("Person.csv");
        Hospital h = new Hospital();


        try {
            h.loadFromFile(fileName);
        } catch (IOException e) {
            System.out.println("Nie udało się wczytać pliku: " + e.getMessage());
        }
        System.out.println("---- Wszyscy pracownicy: ");
        h.getInfo();
        System.out.println("---- Wyplaty wszystkich pracowników łącznie: " + h.payAll(Person.class));
        System.out.println("---- Wypłaty lekarzy łącznie: " + h.payAll(Doctor.class));
        System.out.println("---- Wypłaty wszystkich pielęgniarek łącznie: " + h.payAll(Nurse.class));
        System.out.println("---- Średnia płaca pielęgniarek" + h.average(Nurse.class));
        System.out.println("---- Sorotwanie według wypłaty:");
        h.printSortedByPay();
        try {
            h.saveToFile("Person.csv");
        } catch (IOException e) {
            System.out.println("Nie udało się zapisać pliku: " + e.getMessage());
        }
    }

}
