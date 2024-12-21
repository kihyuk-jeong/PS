package repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TempPoint {
    int x;
    int y;

    public TempPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 통로 {

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, -1, 0, 1};
    private static int[][] weights;
    private static boolean[][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        weights = new int[9][9];
        map = new boolean[9][9];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = sc.nextInt() == 0;
            }
        }

        bfs(1, 1);

        if (weights[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(weights[7][7]);
        }
    }

    private static void bfs(int x, int y) {

        map[x][y] = false;

        Queue<TempPoint> points = new LinkedList<>();

        points.offer(new TempPoint(x, y));

        while (!points.isEmpty()) {

            TempPoint currentPoint = points.poll();
            int cx = currentPoint.x;
            int cy = currentPoint.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dirX[i];
                int ny = cy + dirY[i];

                if (map[nx][ny]) {
                    map[nx][ny] = false;
                    weights[nx][ny] = weights[cx][cy]+1;
                    points.offer(new TempPoint(nx, ny));
                }

            }

        }
    }
}
