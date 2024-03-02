package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class ReversePrimeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(n, array);

    }

    private static void solve(int n, int[] array) {

        int[] validationArray = getFrameNumberArray();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String reverse = builder.append(array[i]).reverse().toString();
            int reverseNumber = Integer.parseInt(reverse);



            if (validationArray[reverseNumber] == 0) {
                System.out.print(reverseNumber +" ");
            }

            builder = new StringBuilder();

        }
    }

    private static int[] getFrameNumberArray() {

        int[] array = new int[100001];

        array[1] = 1;

        for (int i = 2; i < 100001; i++) {
            if (array[i] == 0) {
                for (int j = i + i; j < 100001; j += i) {
                    array[j] = 1;
                }
            }
        }

        return array;
    }

}
