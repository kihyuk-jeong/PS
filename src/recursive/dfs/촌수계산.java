package recursive.dfs;

import java.util.Scanner;

public class 촌수계산 {

    static int answer = -1;
    static boolean[][] graph;
    static boolean[] visited;
    static int n, x, y, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        x = sc.nextInt();
        y = sc.nextInt();

        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();

            graph[parent][child] = true;
            graph[child][parent] = true;
        }

        dfs(x, 0);

        System.out.println(answer);

    }

    private static void dfs(int idx, int count) {

        visited[idx] = true;

        if (y == idx) {
            answer = count;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[idx][i]) {
                dfs(i, count + 1);
            }
        }
    }

}
