package repeat;

import java.util.Scanner;

public class Permeate {
    static int M, N;
    static boolean [][] map;
    static boolean answer;

    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        map = new boolean[M + 2][N + 2];

        for (int i = 1; i <= M; i++) {
            String input = sc.next();
            for (int j = 1; j <= N; j++) {
                char temp = input.charAt(j - 1);
                map[i][j] = temp == '0';
            }
        }

//        for (int i = 1; i <= M; i++) {
//            System.out.println();
//            for (int j = 1; j <= N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//        }

        for (int i = 1; i <= N; i++) {
            dfs(1, i);
        }

        System.out.println(answer ? "YES" : "NO");
    }

    private static void dfs(int y, int x) {
        if (y == M) {
            answer = true;
            return;
        }

        map[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];

            if (map[nextY][nextX]) {
                dfs(nextY, nextX);
            }
        }
    }
}
