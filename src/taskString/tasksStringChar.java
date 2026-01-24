package taskString;

public class tasksStringChar {
    public static void main(String[] args) {

        String word = "Java to zabawa";

        int letterCount = letteCount(word);

        if(letterCount > 10){
            System.out.println("Dużo liter");
        }else if(letterCount <=10){
            System.out.println("Mało liter");
        }


    }

    private static int letteCount(String word) {
        String changeWord = word.replaceAll(" ", "");

        return changeWord.length();
    }
}