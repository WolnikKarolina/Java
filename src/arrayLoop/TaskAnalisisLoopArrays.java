package arrayLoop;

import java.util.Scanner;

public class TaskAnalisisLoopArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj ilość liczb");
        int howManyNumbers = sc.nextInt();
        int[] tab = new int[howManyNumbers];

        for (int i = 0; i < tab.length; i++) {
            System.out.println("Podaj liczbę");
            tab[i] = sc.nextInt();

        }

        int[] analysys = analysys(tab);
        System.out.println("Wyniki:");
        System.out.println("średnia: " + analysys[0]);
        System.out.println("Ilość dodatnich: " + analysys[1]);
        System.out.println("Ilość ujemnych: " + analysys[2]);
        System.out.println("pierwsza liczba większa od 10: " + analysys[3]);
    }

    private static int[] analysys(int[] a) {
        int sum = 0;
        int average = 0;
        int sumPositive = 0;
        int sumNegative = 0;
        int largestThan10 = 0;

        for (int i : a) {
            sum += i;
            average = sum/a.length;
            if ( i < 0){
                sumNegative += i;
            }else if (i > 0)  {
                sumPositive += i;
            }
            if(i > 10){
                largestThan10 = i;
                break;
            }
        }return new int[]{average, sumPositive, sumNegative, largestThan10};




    }


}
