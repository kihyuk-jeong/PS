package repeat.dfs.같은부류찾기;

import java.util.Scanner;

public class 유기농배추 {

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static int m, n, k;
    private static boolean[][] map;
    private static int answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        while (testCase-- > 0) {

            answer = 0;

            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            map = new boolean[n + 2][m + 2];

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[y + 1][x + 1] = true;
            }


            for (int i = 1; i < n + 2; i++) {
                for (int j = 1; j < m + 2; j++) {

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

            int nextY = dirY[i] + y;
            int nextX = dirX[i] + x;

            if (map[nextY][nextX]) {
                dfs(nextY, nextX);
            }
        }
    }
}
