package oop;

public class TravelAgency {
    public static void main(String[] args) {

        ServiceManager sm = new ServiceManager();

        Trip[] trips = {
                new Trip("Wycieczka w góry", 200, 2, 5, true, 3),
                new Trip("Wycieczka nad morze", 150, 1, 4, false, 2),
                new Trip("Zwiedzanie miasta", 100, 1, 10, true, 1),
                new Trip("Wycieczka rowerowa", 120, 2, 8, false, 2),
                new Trip("Wycieczka kulinarna", 180, 1, 2, true, 1)
        };

        Car[] cars = {
                new Car("Toyota Corolla", 100, 1, 5),
                new Car("Ford Transit", 150, 1, 8),
                new Car("Mercedes Vito", 200, 1, 7),
                new Car("Volkswagen Golf", 90, 1, 4),
                new Car("Skoda Octavia", 110, 1, 5)
        };

        addTripOrCars(trips, sm);
        addTripOrCars(cars, sm);
        sm.travelWithGuide();
        sm.rentTheCar("Toyota Corolla");
        sm.returnTheCar("Toyota Corolla", 200, 1);
        sm.sevenSeaterCar();
        sm.addParticipantToTrip("Wycieczka kulinarna");
        sm.addParticipantToTrip("Wycieczka kulinarna");
        sm.addParticipantToTrip("Wycieczka kulinarna");

    }

    private static void addTripOrCars(Service[] services, ServiceManager sm) {
        for (Service s : services) {
        if (sm.addService(s)) {
                System.out.println("Dodano pomyślnie " + s.getName());
            } else {
                System.out.println(" Nie udało się dodać " + s.getName());
            }

        }
    }
}
