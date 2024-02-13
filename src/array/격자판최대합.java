package array;

import java.util.Scanner;

public class 격자판최대합 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(array));


    }

    private static int solve(int[][] array) {

        int n = array.length;

        int answer = Integer.MIN_VALUE;
        int rowSum;
        int colSum;
        int diagonalSum = 0;

        for (int i = 0; i < n; i++) {

            rowSum = 0;
            colSum = 0;

            for (int j = 0; j < n; j++) {
                rowSum += array[i][j];
                colSum += array[j][i];
            }
            answer = Math.max(answer, rowSum);
            answer = Math.max(answer, colSum);
        }

        for (int i = 0; i < n; i++) {
            diagonalSum += array[i][i];
        }
        return Math.max(answer, diagonalSum);
    }
}
