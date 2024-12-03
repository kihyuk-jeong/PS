package recursive.bfs;

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

public class 노맛토 {

    private static int[][] box;
    private static int[][] dis;
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, -1, 0, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        box = new int[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        if (isAlreadyComplete(n, m)) {
            System.out.println("0");
            return;
        }

        bfs(n, m);

        if (isFailComplete(n, m)) {
            System.out.println(-1);
        } else {

            int answer = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }

            System.out.println(answer);

        }

    }

    private static boolean isFailComplete(int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void bfs(int n, int m) {


        Queue<Tomato> queue = new LinkedList<>();
        init(n, m, queue);

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            int curX = tomato.x;
            int curY = tomato.y;

            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dirX[i];
                int ny = tomato.y + dirY[i];

                if ((nx >= 0 && nx < n && ny >= 0 && ny < m) && box[nx][ny] == 0) {
                    queue.offer(new Tomato(nx, ny));
                    box[nx][ny] = 1;
                    dis[nx][ny] = dis[curX][curY] + 1;
                }
            }
        }


    }

    private static void init(int n, int m, Queue<Tomato> queue) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (box[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                }

            }
        }
    }

    private static boolean isAlreadyComplete(int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (box[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
