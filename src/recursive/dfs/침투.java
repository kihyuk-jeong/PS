package recursive.dfs;

import java.util.Scanner;

public class 침투 {

    static int M, N;
    static boolean[][] visited;
    static boolean[][] map;
    static boolean answer;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new boolean[M + 2][N + 2];
        visited = new boolean[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            String input = sc.next();
            for (int j = 1; j <= N; j++) {
                map[i][j] = input.charAt(j - 1) == '0';
            }
        }

        for (int j = 1; j <= N; j++) {
            if (map[1][j]) {
                dfs(1, j);
            }
        }

        System.out.println(answer ? "YES" : "NO");

    }

    private static void dfs(int x, int y) {

        if (x == M) {
            answer = true;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (map[nextX][nextY] && !visited[nextX][nextY]) {
                dfs(nextX, nextY);
            }

        }


    }
}
