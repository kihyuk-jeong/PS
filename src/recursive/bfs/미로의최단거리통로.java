package recursive.bfs;

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

public class 미로의최단거리통로 {

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static boolean[][] map;
    private static int[][] dis;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        map = new boolean[9][9];
        dis = new int[9][9];

        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                int value = sc.nextInt();
                map[i][j] = (value == 0);
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

        Point point = new Point(x, y);

        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);

        while (!queue.isEmpty()) {

            Point current = queue.poll();

            int cx = current.x;
            int cy = current.y;

            map[cx][cy] = false;

            for (int i = 0; i < 4; i++) {
                int nextX = cx + dirX[i];
                int nextY = cy + dirY[i];

                if (map[nextX][nextY]) {
                    queue.offer(new Point(nextX, nextY));
                    dis[nextX][nextY] = dis[cx][cy] + 1;
                }

            }
        }
    }
}
