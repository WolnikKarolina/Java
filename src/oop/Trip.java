package oop;

public class Trip extends Service{
    private boolean withGuide;
    private int lengthTrip;
    private int currentParticipant = 0;

    // robię tylko gettery ponieważ nie chcę później zmianiać tych wartości
    public boolean isWithGuide() {
        return withGuide;
    }

    public int getLengthTrip() {
        return lengthTrip;
    }

    public int getCurrentParticipant() {
        return currentParticipant;
    }

    //do konstruktora nie dodaje currentParticipant bo jest ustawione na 0 = nowa wycieczka to 0 uczestników
    public Trip(String name, double netPrice, int minParticipant, int maxParticipant, boolean withGuide, int lengthTrip) {
        super(name, netPrice, minParticipant, maxParticipant);
        this.withGuide = withGuide;
        this.lengthTrip = lengthTrip;
    }

    @Override
    public String toString() {
        String gudeText = withGuide ? "tak" : "nie"; // wyświetlanie tak/nie zamiast true/false
        return getName() + ", " +
                "przewodnik: " + gudeText  +
                ", ilość dni wycieczki: " + lengthTrip + ", minimalna ilość uczestników: " + getMinParticipant() + ", maxymalna liczba uczestników; " + getMaxParticipant() +
                '}';
    }

    @Override
    public double calculateGrossPrice() {
        return getNetPrice() * 1.08;
    }

    public boolean addParticipant() { // zwracając boolean możemy reagować na sytuacje gdzie dodanie z jakiegoś powodu nie może się udać, gdyby metoda zwracła np int mamy możliwośc tylko dodać lub odjąć
        if (currentParticipant < getMaxParticipant()) {
            currentParticipant++;
            return true;
        } else {
            System.out.println("Maksymalna liczba uczestników została osiągnięta");
            return false;
        }
    }
}
