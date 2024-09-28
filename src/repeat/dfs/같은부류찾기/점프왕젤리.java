package repeat.dfs.같은부류찾기;

import java.util.Scanner;

public class 점프왕젤리 {

    private static int[] dirY = {0, 1};
    private static int[] dirX = {1, 0};

    private static String answer = "Hing";
    private static int n;

    private static int[][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n + 102][n + 102];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(1, 1);

        System.out.println(answer);
    }

    private static void dfs(int y, int x) {

        if (map[y][x] == 0) {
            return;
        }

        if (map[y][x] == -1) {
            answer = "HaruHaru";
            return;
        }

        for (int i = 0; i < 2; i++) {

            int nextY = y + (dirY[i] * map[y][x]);
            int nextX = x + (dirX[i] * map[y][x]);

            dfs(nextY, nextX);
        }

    }

}
