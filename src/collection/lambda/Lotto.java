package collection.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {

        List<Integer> numbersFromUser = new ArrayList<>();
        List<Integer> DrawnNumbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        numbersFromUser(sc, numbersFromUser);
        generate(DrawnNumbers);

        List<Integer> resultNumbers = randomize(DrawnNumbers);
        int lottoCheck = checkResult(numbersFromUser, resultNumbers);

        System.out.println(" Wylosowane liczby: " + resultNumbers);
        System.out.println("Twoje liczby: " + numbersFromUser);
        System.out.println("Wynik losowania; " + lottoCheck);


    }

    private static void numbersFromUser(Scanner sc, List<Integer> numbersFromUser) {
        System.out.println("Podaj 6 liczb od 1 - 49");
        for (int i = 0; i < 6; i++) {
            System.out.println("podaj liczbę");
            int choice = sc.nextInt();
            sc.nextLine();
            numbersFromUser.add(choice);

        }
    }

    private static int checkResult(List<Integer> numbersFromUser, List<Integer> resultNumbers) {
        int found = 0;
        for (Integer i : numbersFromUser) {
            if (resultNumbers.contains(i)) {
                found++;
            }
        }
        return found;
    }

    private static List<Integer> randomize(List<Integer> numbers) {
        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }


    private static void generate(List<Integer> numbers) {
        numbers.clear();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }
    }


}




