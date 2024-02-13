package array;

import java.util.Scanner;

public class 봉우리 {
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

    public static int solve(int[][] array) {

        int arrayLength = array.length;

        int right, left, up, down, position;

        int count = 0;

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {

                position = array[i][j];

                up = getUp(array, i, j);
                down = getDown(array, i, j);
                left = getLeft(array, i, j);
                right = getRight(array, i, j);

                if (position > up && position > down && position > left && position > right) {
                    count++;
                }


            }
        }

        return count;

    }

    private static int getRight(int[][] array, int i, int j) {

        if (j + 1 >= array.length) {
            return 0;
        }

        return array[i][j + 1];
    }

    private static int getLeft(int[][] array, int i, int j) {

        if (j - 1 < 0) {
            return 0;
        }

        return array[i][j - 1];
    }

    private static int getDown(int[][] array, int i, int j) {
        if (i + 1 >= array.length) {
            return 0;
        }
        return array[i + 1][j];
    }

    private static int getUp(int[][] array, int i, int j) {

        if (i - 1 < 0) {
            return 0;
        }
        return array[i - 1][j];

    }
}
