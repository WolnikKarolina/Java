package oop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceManager {

    private List<Service> services = new ArrayList<>();

    public boolean addService(Service e){

        if ((e == null || e.getName() == null || e.getName().isEmpty() || e.getMinParticipant() <= 0 || e.getMaxParticipant() < 1 || e.getNetPrice() <= 0)){
            System.out.println("Niepoprawne wartości");
            return false;
        }else{
            services.add(e);
            return true;
        }
    }

    private List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        for (Service service : services) {
            if (service instanceof Car car) {
                cars.add(car);
            }
        }
        return cars;
    }

    public void showAllCars(){
        for (Car car : getAllCars()) {
            System.out.println(car);
        }
    }

    public void accessibleCar() {
        for (Car car : getAllCars()) {
            if (car.isAvailable()) {
                System.out.println(car);

            }
        }
    }

    public void rentTheCar(String nameOfRentCar){
        for (Car car : getAllCars()) {
            if (car.getName().equals(nameOfRentCar)) {
                if (car.isAvailable()) {
                    car.rentCar();
                    System.out.println("Samochód " + car.getName() + " został wypożyczony");
                }else {
                    System.out.println("Samochód jest niedostępny");
                }
                return;
            }

        } System.out.println("Nie znaleziono auta " + nameOfRentCar);
    }

    public void returnTheCar (String nameOfReturnCar, int currentMilesage, int daysOfRent){
        for (Car car : getAllCars()) {
            if (car.getName().equals(nameOfReturnCar)) {
                double supplement = car.returnCar(currentMilesage, daysOfRent);
                if ( supplement > 0){
                    System.out.println("Samochód " + car.getName() + " został zwrócony, dopłata: " + supplement );
                } else {
                    System.out.println("Samochód " + car.getName() + " został zwrócony");
                }
                return;
            }
        }
        System.out.println("Nie ma takiego samochodu w bazie");
    }

    public void sevenSeaterCar() {
        for (Car car : getAllCars()) {
            if (car.getMaxParticipant() == 7) {
                System.out.println(car);
            }
        }
    }

    private List<Trip> getAllTrips() {
        List<Trip> trips = new ArrayList<>();
        for (Service service : services) {
            if (service instanceof Trip trip) {
                trips.add(trip);
            }
        }
        return trips;
    }
    public void showTravel() {
        for (Trip trip : getAllTrips()) {
            System.out.println(trip);
        }
    }
    public void travelWithGuide() {
        for (Trip trip : getAllTrips()) {
            if (trip.isWithGuide()) {
                System.out.println(trip);
            }

        }
    }

    public void lengthTrip() {
        List<Trip> trips = new ArrayList<>(getAllTrips());
        trips.sort(Comparator.comparing(Trip::getLengthTrip));
        for (Trip trip : trips) {
            System.out.println(trip);
        }
    }

    public void addParticipantToTrip(String tripName) {
        for (Trip trip : getAllTrips()) {
            if (trip.getName().equals(tripName)) {
                boolean add = trip.addParticipant();
                if (add) {
                    System.out.println("Dodano uczestnika do wycieczki " + trip.getName() +
                            ". Aktualna liczba uczestników: " + trip.getCurrentParticipant());
                }else {
                    System.out.println("Nie udało się dodać uczestnika do wycieczki " + trip.getName());
                }
                return;
            }
        }
        System.out.println("Nie znaleziono wycieczki o nazwie: " + tripName);
    }

}

