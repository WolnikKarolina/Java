package taskString;

public class tasksStringChar {
    public static void main(String[] args) {

        String word = "Java to zabawa";

        int letterCount = letterCount(word);

        if(letterCount > 10){
            System.out.println("Dużo liter");
        }else {
            System.out.println("Mało liter");
        }


    }

    private static int letterCount(String word) {
        String changeWord = word.replaceAll(" ", "");

        return changeWord.length();
    }
}