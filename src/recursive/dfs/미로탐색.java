package recursive.dfs;

import java.util.Scanner;

/**
 * 백트래킹 시 현재 위치를 미방문 처리 하는 것이 아닌 내가 방금 갔던 길 (next) 를 다시 가기 위해 미방문 처리 하는 것.
 */

public class 미로탐색 {

    private static int[] dirY = {0, 1, 0, -1};
    private static int[] dirX = {-1, 0, 1, 0};

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

        System.out.println(answer);
    }

    private static void dfs(int y, int x) {

        if (y == 7 && x == 7) {
            answer++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];



            if (map[nextY][nextX]) {

                map[nextY][nextX] = false;
                dfs(nextY, nextX);
                map[nextY][nextX] = true;

            }
        }
    }

}
