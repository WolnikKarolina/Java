package exception.task1;

public class Main {
    public static void main(String[] args) {




        User user = new User("12");
        User user2 = new User("0");
        User user3 = new User("160");
        User user4 = new User("piętnaście");


        checkAge(user);
        checkAge(user2);
        checkAge(user3);
        checkAge(user4);

    }

    private static void checkAge(User user) {
        try {
            int userAge = AgeService.parseAge(user.getAge());
            System.out.println("Wiek użytkownika: " + userAge);
        } catch (NumberFormatException e ){
            System.out.println("Wiek musi być liczbą");
        }catch (IllegalArgumentException e){
        System.out.println("Błąd: " + e.getMessage());
        }
    }
}
