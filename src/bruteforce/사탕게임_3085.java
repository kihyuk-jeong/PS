package bruteforce;

import java.util.Scanner;

public class 사탕게임_3085 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[][] candy = new char[N][N];

        for (int i = 0; i < N; i++) {
            candy[i] = sc.next().toCharArray();
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && candy[i][j] != candy[i][j + 1]) {
                    swapCandy(candy, i, j, i, j + 1);
                    ans = Math.max(ans, Math.max(findMaxRow(candy), findMaxCol(candy)));
                    swapCandy(candy, i, j, i, j + 1);
                }

                if (i + 1 < N && candy[i][j] != candy[i + 1][j]) {
                    swapCandy(candy, i, j, i+1, j );
                    ans = Math.max(ans, Math.max(findMaxRow(candy), findMaxCol(candy)));
                    swapCandy(candy, i, j, i+1, j);
                }
            }
        }

        System.out.println(ans);

    }

    private static int findMaxRow(char[][] candy) {

        int N = candy.length;
        int maxRow = 0;

        for (int i = 0; i < N; i++) {
            int len = 1;
            for (int j = 1; j < N; j++) {
                if (candy[i][j] == candy[i][j - 1]) {
                    len++;
                } else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }

            maxRow = Math.max(maxRow, len);
        }
        return maxRow;
    }

    private static int findMaxCol(char[][] candy) {

        int N = candy.length;
        int maxCol = 0;

        for (int i = 0; i < N; i++) {
            int len = 1;
            for (int j = 1; j < N; j++) {

                if (candy[j][i] == candy[j - 1][i]) {
                    len++;
                } else {
                    maxCol = Math.max(maxCol, len);
                    len = 1;
                }
            }
            maxCol = Math.max(maxCol, len);
        }
        return maxCol;
    }

    private static void swapCandy(char[][] candy, int r1, int c1, int r2, int c2) {
        char temp = candy[r1][c1];
        candy[r1][c1] = candy[r2][c2];
        candy[r2][c2] = temp;
    }

}
