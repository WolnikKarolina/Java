package oop.travleAgencyTask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceManager {

    private List<Service> services = new ArrayList<>(); // tworzę liste wszystkich usług

    public boolean addService(Service e){

        if ((e == null || e.getName() == null || e.getName().isEmpty() || e.getMinParticipant() <= 0 || e.getMaxParticipant() < 1 || e.getNetPrice() <= 0)){
            System.out.println("Niepoprawne wartości");
            return false;
        }else{
            services.add(e);
            return true;
        }
    }

    private List<Car> getAllCars() {// metoda pomocnicza która pozwala na iterowanie po utworzonej liście w której zanjdują się tylko samochody, używana w pozostałych metodach
        List<Car> cars = new ArrayList<>();
        for (Service service : services) {
            if (service instanceof Car car) {
                cars.add(car);
            }
        }
        return cars;
    }

    public void showAllCars(){
        System.out.println(" --- Wszystkie samochody --- ");
        for (Car car : getAllCars()) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void accessibleCar() {
        System.out.println(" --- Dostępne samochody --- ");
        for (Car car : getAllCars()) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
        System.out.println();
    }

    public void rentTheCar(String nameOfRentCar){
        for (Car car : getAllCars()) {
            if (car.getName().equals(nameOfRentCar)) {
                if (car.isAvailable()) {
                    car.rentCar();
                    System.out.println("Samochód " + car.getName() + " został wypożyczony");
                    System.out.println();
                }else {
                    System.out.println("Samochód jest niedostępny");
                    System.out.println();
                }
                return;
            }

        } System.out.println("Nie znaleziono auta " + nameOfRentCar);
        System.out.println();
    }

    public void returnTheCar (String nameOfReturnCar, int currentMilesage, int daysOfRent){
        for (Car car : getAllCars()) {
            if (car.getName().equals(nameOfReturnCar)) {
                double supplement = car.returnCar(currentMilesage, daysOfRent); // metoda z klasy car zwraca dopłatę jeżeli jest przekroczony limit dlatego trzeba ją przypisać do zmiennej
                if ( supplement > 0){
                    System.out.println("Samochód " + car.getName() + " został zwrócony, dopłata: " + supplement );
                    System.out.println();
                } else {
                    System.out.println("Samochód " + car.getName() + " został zwrócony");
                    System.out.println();
                }
                return;
            }
        }
        System.out.println("Nie ma takiego samochodu w bazie");
        System.out.println();
    }

    public void sevenSeaterCar() {
        System.out.println(" --- Samochody siedmioosobowe --- ");
        for (Car car : getAllCars()) {
            if (car.getMaxParticipant() == 7) {
                System.out.println(car);
            }
        }
        System.out.println();
    }

    private List<Trip> getAllTrips() { // metoda pomocnicza do iterowania po wycieczkach analogicznie jak po samochodach
        List<Trip> trips = new ArrayList<>();
        for (Service service : services) {
            if (service instanceof Trip trip) {
                trips.add(trip);
            }
        }
        return trips;
    }

    public void showTravel() {
        System.out.println(" --- Wszystkie wycieczki --- ");
        for (Trip trip : getAllTrips()) {
            System.out.println(trip);
        }
        System.out.println();
    }

    public void travelWithGuide() {
        System.out.println(" --- Wycieczki z przewodnikiem --- ");
        for (Trip trip : getAllTrips()) {
            if (trip.isWithGuide()) {
                System.out.println(trip);
            }
        }
        System.out.println();
    }

    public void lengthTrip() {
        System.out.println(" --- Wycieczki według czasu trwania --- ");
        List<Trip> trips = new ArrayList<>(getAllTrips());
        trips.sort(Comparator.comparing(Trip::getLengthTrip));
        for (Trip trip : trips) {
            System.out.println(trip);
        }
        System.out.println();
    }

    public void addParticipantToTrip(String tripName) {
        for (Trip trip : getAllTrips()) {
            if (trip.getName().equals(tripName)) {
                boolean add = trip.addParticipant(); // metoda z klasy trip zwraca boolena
                if (add) {
                    System.out.println("Dodano uczestnika do wycieczki " + trip.getName() +
                            ". Aktualna liczba uczestników: " + trip.getCurrentParticipant());
                    System.out.println();
                }else {
                    System.out.println("Nie udało się dodać uczestnika do wycieczki " + trip.getName());
                    System.out.println();
                }
                return;
            }
        }
        System.out.println("Nie znaleziono wycieczki o nazwie: " + tripName);
        System.out.println();
    }

}

