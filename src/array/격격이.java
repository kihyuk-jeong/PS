package array;

import java.util.Scanner;

public class 격격이 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(n, array));
    }

    public static int solve(int n, int[][] array) {

        int answer = Integer.MIN_VALUE;
        int sum1;
        int sum2;

        for (int i = 0; i < n; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < n; j++) {

                sum1 += array[i][j];
                sum2 += array[j][i];
            }

            answer = Math.max(sum1, sum2);
        }

        sum1 = 0;
        sum2 = 0;

        for (int i = 0; i < n; i++) {

            sum1 += array[i][i];
            sum2 += array[i][n - i - 1];
        }


        return Math.max(answer, Math.max(sum1, sum2));
    }
}
