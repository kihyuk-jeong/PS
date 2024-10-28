package repeat.dfs;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1388
 */

public class 바닥_장식 {

    static int N, M;
    static String[][] map;
    static boolean[][] visited;

    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new String[N + 112][M + 112];
        visited = new boolean[N + 112][M + 112];

        for (int i = 1; i <= N; i++) {
            String input = sc.next();
            for (int j = 1; j <= M; j++) {
                map[i][j] = input.substring(j - 1, j);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int y, int x) {

        visited[y][x] = true;

        String now = map[y][x];

        if (("-").equals(now) && "-".equals(map[y][x + 1])) {
            dfs(y, x + 1);
        }

        if (("|").equals(now) && ("|").equals(map[y + 1][x])) {
            dfs(y + 1, x);
        }
    }
}
