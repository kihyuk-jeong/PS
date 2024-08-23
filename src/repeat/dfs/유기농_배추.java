package repeat.dfs;

import java.util.Scanner;

public class 유기농_배추 {

    static int T, M, N, K;
    static boolean[][] map;
    static int[] dirY = {1, -1, 0, 0};
    static int[] dirX = {0, 0, 1, -1};
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        while (T-- > 0) {

            answer = 0;
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            map = new boolean[N + 2][M + 2];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[y+1][x+1] = true;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {

                    if (map[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(answer);

        }
    }

    private static void dfs(int y, int x) {

        map[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];


            if (map[nextY][nextX]) {
                dfs(nextY, nextX);
            }

        }

    }

}
