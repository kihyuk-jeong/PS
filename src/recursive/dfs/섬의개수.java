package recursive.dfs;

import java.util.Scanner;

public class 섬의개수 {

    static int w, h;
    static int answer;
    static boolean[][] map;

    static int dirY[] = { -1, -1, 0, 1, 1, 1, 0, -1};
    static int dirX[] = { 0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            // map 배열 생성
            map = new boolean[h + 2][w + 2];

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    int input = sc.nextInt();
                    map[i][j] = input == 1;
                }
            }

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {

                    if (map[i][j]) {
                        dfs(i, j);
                        answer++;
                    }

                }
            }
            System.out.println(answer);
            answer = 0;
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
