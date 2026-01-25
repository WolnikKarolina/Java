package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class listsTask1 {
    public static void main(String[] args) {


        List<String> firstnames = new ArrayList<>();
        List<String> firstnames2 = new LinkedList<>();

        firstnames.add("Anna");
        firstnames.add("Basia");
        firstnames.add("Kasia");
        firstnames.add("Asia");
        firstnames.add("Zosia");

        firstnames2.add("Majka");
        firstnames2.add("Małgorzata");
        firstnames2.add("Marcelina");
        firstnames2.add("Marta");
        firstnames2.add("Michalina");
        System.out.println("ArrayList: " + firstnames);
        System.out.println("LinkedList: " + firstnames2);

        firstnames.add(0, "Róża");
        firstnames2.add(0, "Henia");

        firstnames.remove(1);
        firstnames2.remove("Majka");

       boolean ifContains = firstnames.contains("Majka");
        System.out.println("ArrayList zawiera Majka? " + ifContains);
        System.out.println("LinkedList zawiera Marta: " + firstnames2.contains("Marta")); ;


        System.out.println("ArrayList po zmianach: " + firstnames);
        System.out.println("LinkedList po zmianach: " + firstnames2);

    }

}

