package repeat.dfs.연결요소;

import java.util.Scanner;

public class 촌수계산 {

    private static int n, m, start, end;
    private static boolean [][] graph;
    private static boolean [] visited;

    private static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정점
        n = sc.nextInt();

        start = sc.nextInt();
        end = sc.nextInt();

        // 간선
        m = sc.nextInt();

        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(start, 0);

        System.out.println(answer);
    }

    private static void dfs(int idx, int count) {

        if (end == idx) {
            answer = count;
            return;
        }

        visited[idx] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[idx][i]) {
                dfs(i, count + 1);
            }
        }
    }


}
