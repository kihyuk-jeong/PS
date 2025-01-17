package repeat.more;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TomatoPoint {
    int x;
    int y;

    public TomatoPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 노맛토 {

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, -1, 0, 1};

    // 토마토를 담을 2차워 배열
    private static int[][] tomato;
    // date 를 담을 2차원 배열
    private static int[][] date;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        tomato = new int[n][m];
        date = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tomato[i][j] = sc.nextInt();
            }
        }


        if (isAlreadyComplete(n, m)) {
            System.out.println(0);
            return;
        }

        bfs(n, m);

        if (isFailed(n, m)) {
            System.out.println(-1);
        } else {
            int answer = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, date[i][j]);

                }
            }
            System.out.println(answer);
        }
    }

    private static boolean isFailed(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (tomato[i][j] == 0) {
                    return true;
                }

            }
        }
        return false;
    }

    private static void bfs(int n, int m) {

        Queue<TomatoPoint> queue = new LinkedList<>();

        init(n, m, queue);

        while (!queue.isEmpty()) {

            TomatoPoint current = queue.poll();
            int cx = current.x;
            int cy = current.y;

            for (int i = 0; i < 4; i++) {

                int nextX = dirX[i] + cx;
                int nextY = dirY[i] + cy;

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && tomato[nextX][nextY] == 0) {
                    tomato[nextX][nextY] = 1;
                    queue.offer(new TomatoPoint(nextX, nextY));
                    date[nextX][nextY] = date[cx][cy] + 1;
                }

            }


        }


    }

    private static void init(int n, int m, Queue<TomatoPoint> queue) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 1) {
                    queue.offer(new TomatoPoint(i, j));
                }
            }
        }
    }

    private static boolean isAlreadyComplete(int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
