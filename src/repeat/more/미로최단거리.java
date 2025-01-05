package repeat.more;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PointType {
    int x;
    int y;

    public PointType(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 미로최단거리 {

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, -1, 0, 1};

    private static int[][] answers;
    private static boolean[][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        answers = new int[9][9];
        map = new boolean[9][9];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = sc.nextInt() == 0;
            }
        }

        bfs(1, 1);

        if (answers[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answers[7][7]);
        }


    }

    private static void bfs(int x, int y) {

        Queue<PointType> queue = new LinkedList<>();
        queue.offer(new PointType(x, y));

        while (!queue.isEmpty()) {

            PointType current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dirX[i] + current.x;
                int ny = dirY[i] + current.y;

                if (map[nx][ny]) {
                    answers[nx][ny] = answers[current.x][current.y] + 1;
                    queue.offer(new PointType(nx, ny));
                }

            }
            map[current.x][current.y] = false;
        }

    }
}
