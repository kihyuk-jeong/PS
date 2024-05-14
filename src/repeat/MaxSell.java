package repeat;

import java.util.Scanner;

public class MaxSell {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(n, k, array);


    }

    private static void solve(int n, int k, int[] array) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += array[i];
        }

        int max = sum;


        for (int i = k; i < n; i++) {

            sum = sum - array[i - k] + array[i];
            max = Math.max(sum, max);
        }


        System.out.println(max);
    }
}
