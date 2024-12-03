package repeat;

import java.util.Scanner;

public class Mero {

    private static boolean[][] map;

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, -1, 0, 1};

    private static int answer = 0;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        map = new boolean[9][9];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = sc.nextInt() == 0;
            }
        }

        dfs(1, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y) {

        if (x == 7 && y == 7) {
            answer++;
            return;
        }

        map[x][y] = false;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (map[nextX][nextY]) {
                map[nextX][nextY] = false;
                dfs(nextX, nextY);
                map[nextX][nextY] = true;
            }
        }

    }


}
