package collection.map.task;

import java.util.HashMap;
import java.util.Map;

public class Company {


    Map<String, Employee> employees = new HashMap<>();

    private String createKey(String firstName, String lastName){
        return (firstName + " "  + lastName).toLowerCase();

    }

    public void addEmployee(Employee employee){
        String key = createKey(employee.getFirstName(), employee.getLastName());
        employees.put(key, employee);
    }

    public Employee getEmployee( String firstName, String lastName){
        String key = createKey(firstName, lastName);
        return employees.get(key);
    }



}
