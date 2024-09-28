package repeat.dfs.같은부류찾기;

import java.util.Scanner;

public class 침투 {

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    private static boolean [][] map;
    private static int m, n;

    private static String answer = "NO";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        map = new boolean[m + 2][n + 2];

        for (int i = 1; i <= m; i++) {
            String input = sc.next();
            for (int j = 1; j <= n; j++) {
                map[i][j] = input.charAt(j - 1) == '0';
            }
        }

        for (int i = 1; i <= n; i++) {
            dfs(1, i);
        }

        System.out.println(answer);
    }

    private static void dfs(int y, int x) {

        map[y][x] = false;

        if (y == m) {
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
