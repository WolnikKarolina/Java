package taskString;

public class tasksStringPalindrome {
    public static void main(String[] args) {


        String word = "A man a plan a canal Panama";

        ifPalindrome(word);


    }

    private static void ifPalindrome(String word) {
        word = word.replaceAll(" ", "").toLowerCase();

        String sb = new StringBuilder(word).reverse().toString();
       if(word.equals(sb)){
            System.out.println(" jest palindromem");

        }else {
            System.out.println("nie jest palindromem");
        }
    }
}
