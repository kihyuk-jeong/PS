package recursive.dfs;

import java.util.Scanner;

public class 배추 {

    static int T, M, N, K;
    static int[] pointX = {-1, 1, 0, 0};
    static int[] pointY = {0, 0, -1, 1};
    static int answer;

    static boolean[][] map;

    static void DFS(int x, int y) {

        map[x][y] = false;

        for (int i = 0; i < 4; i++) {
            int nextX = x + pointX[i];
            int nextY = y + pointY[i];

            if (map[nextX][nextY]) {
                DFS(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {

            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            map = new boolean[N + 100][M + 100];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[y + 1][x + 1] = true;
            }

            answer = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j]) {
                        DFS(i, j);
                        answer++;
                    }

                }
            }
            System.out.println(answer);
        }
    }
}
