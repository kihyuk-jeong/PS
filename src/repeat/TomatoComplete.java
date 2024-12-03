package repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato {
    int x;
    int y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class TomatoComplete {
    private static int n, m;
    private static int[][] map;
    private static int[][] dis;

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, -1, 0, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        map = new int[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        bfs();

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                answer = Math.max(answer, dis[i][j]);

            }
        }

        System.out.println(answer);
    }

    private static void bfs() {

        Queue<Tomato> queue = new LinkedList<>();
        init(queue);

        while (!queue.isEmpty()) {

            Tomato currentTomato = queue.poll();

            int cx = currentTomato.x;
            int cy = currentTomato.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dirX[i];
                int ny = cy + dirY[i];

                if ((nx >= 0 && nx < n && ny >= 0 && ny < m) && map[nx][ny] == 0) {
                    queue.offer(new Tomato(nx, ny));
                    map[nx][ny] = 1;
                    dis[nx][ny] = dis[cx][cy] + 1;
                }
            }
        }


    }

    private static void init(Queue<Tomato> queue) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                }
            }
        }
    }

}
