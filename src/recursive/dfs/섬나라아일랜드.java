package recursive.dfs;

import java.util.Scanner;

public class 섬나라아일랜드 {

    private static int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static boolean[][] map;
    private static int n;
    private static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new boolean[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt() == 1;
            }
        }


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
            int nx = x + dirX[i];
            int ny = y + dirY[i];

            if (map[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
