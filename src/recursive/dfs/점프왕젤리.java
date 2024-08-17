package recursive.dfs;

import java.util.Scanner;

// https://www.acmicpc.net/problem/16173
public class 점프왕젤리 {

    static int MAX = 113;
    static int N;
    static boolean [][] visited;
    static int [][] map;
    static boolean answer;

    static int[] dirY = {1, 0};
    static int[] dirX = {0, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(1, 1);

        System.out.println(answer ? "HaruHaru" : "Hing");
    }

    private static void dfs(int y, int x) {

        if (y == N && x == N) {
            answer = true;
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 2; i++) {
            int nextY = y + dirY[i] * map[y][x];
            int nextX = x + dirX[i] * map[y][x];

            if (!visited[nextY][nextX]) {
                dfs(nextY, nextX);
            }

        }



    }
}
