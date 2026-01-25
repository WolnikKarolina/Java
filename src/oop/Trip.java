package oop;

public class Trip extends Service{
    private boolean withGuide;
    private int lengthTrip;
    private int currentParticipant = 0;

    public boolean isWithGuide() {
        return withGuide;
    }

    public int getLengthTrip() {
        return lengthTrip;
    }

    public int getCurrentParticipant() {
        return currentParticipant;
    }

    public Trip(String name, double netPrice, int minParticipant, int maxParticipant, boolean withGuide, int lengthTrip) {
        super(name, netPrice, minParticipant, maxParticipant);
        this.withGuide = withGuide;
        this.lengthTrip = lengthTrip;
    }

    @Override
    public String toString() {
        String gudeText = withGuide ? "tak" : "nie";
        return getName() + ", " +
                "przewodnik: " + gudeText  +
                ", ilość dni wycieczki: " + lengthTrip + ", minimalna ilość uczestników: " + getMinParticipant() + ", maxymalna liczba uczestników; " + getMaxParticipant() +
                '}';
    }

    @Override
    public double calculateGrossPrice() {
        return getNetPrice() * 1.08;
    }

    public boolean addParticipant() {
        if (currentParticipant < getMaxParticipant()) {
            currentParticipant++;
            return true;
        } else {
            System.out.println("Maksymalna liczba uczestników została osiągnięta");
            return false;
        }
    }
}
