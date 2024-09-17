package repeat.dfs.연결요소;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퓨전 {

    private static int n, m, v;
    private static boolean[] visited;
    private static boolean[][] graph;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(v);

        visited = new boolean[n + 1];

        System.out.println();
        bfs(v);

    }

    private static void bfs(int idx) {

        visited[idx] = true;

        queue.offer(idx);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (int i = 1; i <=n; i++) {

                if (!visited[i] && graph[current][i]) {
                    visited[i] = true;
                    queue.offer(i);
                }

            }

        }

    }

    private static void dfs(int idx) {

        System.out.print(idx + " ");

        visited[idx] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[idx][i]) {
                dfs(i);
            }
        }

    }
}
