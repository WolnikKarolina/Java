package exception.task1;

public class User {
    private String age;

    public User() {
    }

    public User(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Wiek użytkownika: " + age;
    }
}
