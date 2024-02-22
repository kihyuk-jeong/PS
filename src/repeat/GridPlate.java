package repeat;

import java.util.Scanner;

// 격자판최대합

public class GridPlate {
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

    private static int solve(int n, int[][] array) {

        int max = Integer.MIN_VALUE;
        int rowSum;
        int colSum;

        for (int i = 0; i < n; i++) {
            rowSum = 0;
            colSum = 0;
            for (int j = 0; j < n; j++) {

                rowSum+= array[i][j];
                colSum+= array[j][i];
            }


            max = Math.max(rowSum, max);
            max = Math.max(colSum, max);

        }

        rowSum = 0;
        colSum = 0;
        for (int i = 0; i < n; i++) {
            rowSum += array[i][i];
            colSum += array[i][n - i - 1];
        }

        max = Math.max(rowSum, max);
        max = Math.max(colSum, max);

        return max;

    }
}
