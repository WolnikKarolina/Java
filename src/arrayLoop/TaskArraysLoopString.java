package arrayLoop;

import java.util.Scanner;

public class TaskArraysLoopString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String[] words = readWords(sc);
        joinWords(words);
        lengthOfWords(words);
        arrayReverse(words);
        find(sc, words);


    }

    private static void find(Scanner sc, String[] words) {
        System.out.println("Podaj ciąg do wyszukania ");
        String find = sc.nextLine();

        for (String word : words) {
            if (word.contains(find)){
                System.out.print("Wyrazy zawierające " + find + ": " + word);
            }

        }
    }

    private static void arrayReverse(String[] words) {
        for (int i = 0; i < words.length/2; i++) {
            String temp = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - i - 1] = temp;
        }

        for (String word : words) {
            System.out.print(word + " ");

        }
        System.out.println();
    }

    private static void lengthOfWords(String[] words) {
        for (int i = 0; i < words.length; i++) {
            int lenght = words[i].length();
            System.out.println("Długość " + (i + 1) + " słowa to " + lenght);
        }
    }

    private static void joinWords(String[] words) {
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static String[] readWords(Scanner sc) {
        System.out.print("Podaj ile wyrazów chcesz wprowadzić ");
        int wordsToEnter = sc.nextInt();
        sc.nextLine();
        String[] words = new String[wordsToEnter];

        for (int i = 0; i < words.length; i++) {
            System.out.println("Podaj wyraz " + (i+1));
            words[i] = sc.nextLine();
        }
        return words;
    }

}
