package exception.task1;

public class User {
    private String age;

    public User(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

     @Override
    public String toString() {
        return "Wiek użytkownika: " + age;
    }
}
