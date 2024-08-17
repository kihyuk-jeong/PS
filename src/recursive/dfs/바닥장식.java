package recursive.dfs;

import java.util.Scanner;

public class 바닥장식 {

    static int N, M;
    static int answer;

    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N + 2][M + 2];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String input = sc.next();
            for (int j = 1; j <= M; j++) {
                map[i][j] = input.charAt(j - 1);
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

        if (map[y][x] == '-' && map[y][x + 1] == '-') {
            dfs(y, x + 1);
        } else if (map[y][x] == '|' && map[y + 1][x] == '|') {
            dfs(y + 1, x);
        }
    }
}
