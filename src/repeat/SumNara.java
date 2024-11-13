package repeat;

import java.util.Scanner;

public class SumNara {

    private static int n;
    private static int[] dirX = {1, 1, 1, -1, -1, -1, 0, 0};
    private static int[] dirY = {0, -1, 1, 0, 1, -1, -1, 1};
    private static boolean [][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new boolean[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = (sc.nextInt() == 1);
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j]) {
                    answer++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y) {

        map[x][y] = false;

        for (int i = 0; i < 8; i++) {

            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (map[nextX][nextY]) {
                dfs(nextX, nextY);
            }

        }
    }

}
