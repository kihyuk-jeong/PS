package repeat.dfs;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/13565
 */
public class 침투 {

    static int M, N;
    static int[] dirY = {-1, 0, 1, 0};
    static int[] dirX = {0, -1, 0, 1};

    static String answer = "NO";
    static boolean [][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new boolean[M + 2][N + 2];

        for (int i = 1; i <= M; i++) {
            String input = sc.next();
            for (int j = 1; j <= N; j++) {
                map[i][j] = input.charAt(j - 1) == '0';
            }
        }

        for (int i = 1; i <= N; i++) {
            if (map[1][i]) {
                dfs(1, i);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int y, int x) {

        map[y][x] = false;

        if (y == M) {
            answer = "YES";
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];

            if (map[nextY][nextX]) {
                dfs(nextY, nextX);
            }
        }




    }
}
