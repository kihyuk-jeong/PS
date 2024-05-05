package twopointer;

import java.util.Scanner;

public class 연속된자연수의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[n/2 +1];

        for (int i = 0; i < n / 2 + 1; i++) {
            array[i] = i+1;
        }

        solve(n, array);

    }

    private static void solve(int n, int[] array) {

        int length = array.length;

        int lt = 0;
        int sum = 0;
        int count = 0;

        for (int rt = 0; rt < length; rt++) {
            sum += array[rt];

            if (sum == n) {
                count++;
            }

            while (sum >= n) {
                sum -= array[lt];
                lt++;

                if (sum == n) {
                    count++;
                }


            }


        }

        System.out.println(count);

    }

}
