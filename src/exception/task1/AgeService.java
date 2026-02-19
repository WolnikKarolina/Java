package exception.task1;

public class AgeService {

    public static int parseAge(String age) {
        int ageFromString = Integer.parseInt(age);
        if ( ageFromString <= 0 || ageFromString > 150) {
            throw new IllegalArgumentException("Nieprawidłowy wiek");
        }
        return ageFromString;
    }
}
