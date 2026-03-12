package optional;


import java.util.Map;
import java.util.Optional;

public class Main {
    static void main() {

        Map<String, String> emails = Map.of("Ania", "ania@mail.com",
                "Ola", "ola@mail.com");

        System.out.println(emails.containsKey("ewa")); // sprawdzam co wyświetli
        Optional<String> name = Optional.ofNullable(emails.get("Ewa"));
        name.ifPresentOrElse(
                v -> System.out.println("Email " + v),
                () ->System.out.println("nie znaleziono emaila"));

        // jeżeli znajdzie maila wypisz go dużymi literami
        Optional<String> name2 = Optional.ofNullable(emails.get("Ania"));
        name2.ifPresentOrElse(
                v -> System.out.println("Email " + v.toUpperCase()),
                () ->System.out.println("nie znaleziono emaila"));

        // sprawdz czy zawiera mail.com
        Optional.ofNullable(emails.get("Ola"))
                .filter(m -> m.contains("mail.com"))
                .ifPresentOrElse(
                        m -> System.out.println("Tak, zawiera mail.com"),
                        () -> System.out.println("Nie zawiera mail.com")
                );

        // pobierz emial Ewy
        String emailEwa = Optional.ofNullable(emails.get("Ewa"))
                .orElse("default@mail.com");
        System.out.println(emailEwa);
    }
}
