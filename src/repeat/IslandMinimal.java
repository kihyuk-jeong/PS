package repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class IslandMinimal {

    private static boolean[][] map;
    private static int[][] dis;

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, -1, 0, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        map = new boolean[9][9];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = sc.nextInt() == 0;
            }
        }


        bfs(1, 1);

        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }

    private static void bfs(int x, int y) {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {

            Point currentPoint = queue.poll();

            int cx = currentPoint.x;
            int cy = currentPoint.y;

            map[cx][cy] = false;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dirX[i];
                int ny = cy + dirY[i];

                if (map[nx][ny]) {
                    dis[nx][ny] = dis[cx][cy] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }
}
