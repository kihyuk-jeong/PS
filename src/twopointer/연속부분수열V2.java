package twopointer;

import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class 연속부분수열V2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(n, m, array);

    }

    private static void solve(int n, int m, int[] array) {

        int lt = 0;

        int sum = 0;
        int count = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += array[rt];
            if (sum == m) {
                count++;
            }

            while (sum >= m) {
                sum -= array[lt];
                lt++;

                if (sum == m) {
                    count++;
                }

            }
        }

        System.out.println(count);

    }
}
