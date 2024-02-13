package array;

import java.util.Scanner;

public class 봉우리2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(array, n));
    }

    private static int solve(int[][] array, int n) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                boolean isBongWori = true;

                for (int k = 0; k < 4; k++) {

                    if (i + dx[k] >= 0 && i + dx[k] < n && j + dy[k] >= 0 && j + dy[k] < n && array[i + dx[k]][j + dy[k]] >= array[i][j]) {
                        isBongWori = false;
                        break;
                    }
                }

                if (isBongWori) {
                    count++;
                }


            }
        }
        return count;
    }
}