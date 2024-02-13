package array;

import java.util.Scanner;

public class 뒤집은소수 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] inputs = new String[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = sc.next();
        }

        solve(n, inputs);

    }

    public static void solve(int n, String[] inputs) {

        int[] isPrimeNumbers = isPrimeNumberArray();

        for (int i = 0; i < n; i++) {
            String number = new StringBuilder(inputs[i]).reverse().toString();
            int reverseNumber = Integer.parseInt(number);
            if (isPrimeNumbers[reverseNumber] == 0) {
                System.out.print(reverseNumber+ " ");
            }
        }

    }

    private static int[] isPrimeNumberArray() {

        int[] array = new int[100001];

        array[0] = 1;
        array[1] = 1;

        for (int i = 2; i < 100001; i++) {
            if (array[i] == 0) {
                for (int j = i+i; j < 100001; j += i) {
                    array[j] = 1;
                }
            }
        }
        return array;
    }

}
