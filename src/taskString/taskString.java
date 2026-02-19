package taskString;

import java.util.Scanner;

public class taskString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        processWord(sc);

    }

    private static void processWord(Scanner sc) {
        String word = readWord(sc);
        word = prepareWord(word);
        printLength(word);
        printFirstLastLetter(word);
        checkContainsA(word);
        word = replaceAwithX(word);
        printCharArray(word);
    }

    private static void printCharArray(String word) {
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < wordArray.length; i++) {
            System.out.println(wordArray[i]);
            if(i < wordArray.length - 1){
                System.out.print(", ");
            }

        }
        System.out.println();
    }

    private static String replaceAwithX(String word) {
        word = word.replace("A", "X");
        return word;
    }

    private static void checkContainsA(String word) {
        boolean a = word.contains("A");
        if (a){
            System.out.println("Czy zawiera literę 'A': Tak");
        }else{
            System.out.println("Czy zawiera literę 'A': Nie");
        }
    }

    private static void printFirstLastLetter(String word) {
        char firstLetter = word.charAt(0);
        System.out.println("Pierwsza litera: " + firstLetter);
        char lastLetter = word.charAt(word.length()-1);
        System.out.println("Ostatnia litera: " + lastLetter);
    }

    private static void printLength(String word) {
        int length = word.length();
        System.out.println("Długość słowa: " + length);
    }

    private static String prepareWord(String word) {
        word = word.trim().toUpperCase();
        return word;
    }

    private static String readWord(Scanner sc) {
        System.out.println("Podaj słowo");
        return sc.nextLine();
    }
}