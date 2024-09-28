package repeat.dfs.같은부류찾기;

import java.util.Scanner;

public class 섬의개수 {

    private static int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static boolean[][] map;
    private static int answer;

    private static int w, h;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            answer = 0;

            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            map = new boolean[h + 2][w + 2];

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    map[i][j] = (sc.nextInt() == 1);
                }
            }

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {

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

        for (int i = 0; i < 8; i++) {

            int nextY = y + dirY[i];
            int nextX = x + dirX[i];

            if (map[nextY][nextX]) {
                dfs(nextY, nextX);
            }


        }

    }

}
