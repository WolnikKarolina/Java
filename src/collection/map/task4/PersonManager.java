package collection.map.task4;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class PersonManager {
    Map<String, Person> map = new TreeMap<>();

    public void addPerson(String lastName, Person person){
        map.put(lastName, person);
    }

    public void printPersons(){
        Iterator<Map.Entry<String, Person>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Person> entry = iterator.next();
            System.out.println(entry.getValue());
        }
    }
}
