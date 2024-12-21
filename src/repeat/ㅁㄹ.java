package repeat;

import java.util.Scanner;

public class ㅁㄹ {

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, -1, 0, 1};

    private static boolean[][] map;

    private static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        map = new boolean[9][9];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = sc.nextInt() == 0;
            }
        }

        map[1][1] = false;

        dfs(1, 1);



    }

    private static void dfs(int x, int y) {

        if (x == 7 && y == 7) {
            answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {

            int nx = x + dirX[i];
            int ny = y + dirY[i];

            if (map[nx][ny]) {
                map[nx][ny] = false;
                dfs(nx, ny);
                map[nx][ny] = true;
            }
        }

    }
}
