package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class ContinuousSeq {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        solve(N, M, array);


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
