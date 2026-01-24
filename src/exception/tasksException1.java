package exception;

public class tasksException1 {
    public static void main(String[] args) {


        try {
            int result = divide(3, 0);
            System.out.print("sesult");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        int a = 10;
        int b = 0;
        try {
            int result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Ups, dzielenie przez zero");
        } finally {
            System.out.println("Blok finnaly zawsze działa");
        }

        String number = "Jeden2";
        try {
            int numberByInt = Integer.parseInt(number);
            System.out.println("Liczba to " + numberByInt);
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawna liczba");
        }

        try {
            int numberByInt = toInt(number);
            System.out.println("Liczba to: " + numberByInt);
        }catch  (NumberFormatException e) {
            System.out.println(e.getMessage());
        }






    }

    private static int toInt(String number) throws NumberFormatException {
        return Integer.parseInt(number);

    }


    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("Nie można dzielić przez 0");
        return a / b;
    }

}