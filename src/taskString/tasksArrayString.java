package taskString;


public class tasksArrayString {
    public static void main(String[] args) {

        String[] words = {"Java", "to", "zabawa"};

        int[] letterCount = new int[words.length];
        letterCount = stringToInt(words);

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + " -> " + letterCount[i]);

        }
    }

    private static int[] stringToInt(String[] words) {
        int[] stringToInt = new int[words.length];

        for (int i = 0; i < stringToInt.length; i++) {
            stringToInt[i] = words[i].length();

        }
        return stringToInt;
    }


}
