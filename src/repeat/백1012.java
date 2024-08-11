package repeat;

import java.util.Scanner;

public class 백1012 {

    static int M,N,K;
    static int[] pointX = {-1, 1, 0, 0};
    static int[] pointY = {0, 0, -1, 1};
    static boolean[][] map;
    static int answer;

    public static void main(String[] args) {

        // M : 가로길이
        // N : 세로길이
        // 즉, boolean 배열 array[N][M]

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        // 좌표 탐색 시 index 초과 가능
        map = new boolean[N + 2][M + 2];

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[y + 1][x + 1] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j]) {
                    dfs(i, j);
                    answer++;
                }

            }
        }

        System.out.println(answer);





    }

    private static void dfs(int x, int y) {

        map[x][y] = false;

        for (int i = 0; i < 4; i++) {
            int nextI = x + pointX[i];
            int nextJ = y + pointY[i];

            if (map[nextI][nextJ]) {
                dfs(nextI,nextJ);
            }

        }

    }
}
