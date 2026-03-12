package multiFeatureTasks.hospital;

public class HospitalApp {
    static void main(String[] args) {


        Hospital h = new Hospital();
        h.addEmployee(new Doctor("Maciek", "Prefeska", 7500.00, 1300));
        h.addEmployee(new Nurse("Ania", "Dobroszewska", 2200.00, 6));
        h.addEmployee(new Nurse("Marta", "Danielska", 2500, 3));
        h.addEmployee(new Doctor("Anna", "Kowalska", 15000, 3000));
        h.addEmployee(new Doctor("Michał", "Nowicki", 18000, 4000));
        h.addEmployee(new Doctor("Karolina", "Mazur", 14000, 2500));
        h.addEmployee(new Nurse("Ola", "Nowak", 8500, 5));
        h.addEmployee(new Nurse("Katarzyna", "Wiśniewska", 9200, 8));
        h.addEmployee(new Nurse("Tomasz", "Lewandowski", 7800, 3));
        h.addEmployee(new Nurse("Magda", "Zielińska", 8800, 6));

        System.out.println("---- Wszyscy pracownicy: ");
        h.getInfo();
        System.out.println("---- Wyplaty wszystkich pracowników łącznie: " + h.payAll(Person.class));
        System.out.println("---- Wypłaty lekarzy łącznie: " + h.payAll(Doctor.class));
        System.out.println("---- Wypłaty wszystkich pielęgniarek łącznie: " + h.payAll(Nurse.class));
        System.out.println("---- Średnia płaca pielęgniarek" + h.average(Nurse.class));
        System.out.println("---- Sorotwanie według wypłaty:");
        h.printSortedByPay();
    }

}
