package collection.map.task4;

public class PersonApp {
    static void main(String[] args) {

        PersonManager pm = new PersonManager();
        pm.addPerson("Kowalski", new Person("Jan", "Kowalski", 45));
        pm.addPerson("Nowak", new Person("Anna", "Nowak", 32));
        pm.addPerson("Wiśniewski", new Person("Tomasz", "Wiśniewski", 28));
        pm.addPerson("Zieliński", new Person("Katarzyna", "Zielińska", 41));
        pm.addPerson("Wójcik", new Person("Piotr", "Wójcik", 37));
        pm.addPerson("Kamiński", new Person("Magdalena", "Kamińska", 25));
        pm.addPerson("Lewandowski", new Person("Michał", "Lewandowski", 50));
        pm.addPerson("Dąbrowski", new Person("Agnieszka", "Dąbrowska", 29));
        pm.addPerson("Kaczmarek", new Person("Paweł", "Kaczmarek", 34));
        pm.addPerson("Mazur", new Person("Ewa", "Mazur", 46));
        pm.addPerson("Król", new Person("Karol", "Król", 31));

        pm.printPersons();
    }
}
