package recursive.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퓨전 {

    static int n, m, v;
    static Queue<Integer> queue;
    static boolean[] visited;
    static boolean[][] graph;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        queue = new LinkedList<>();
        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        DFS(v);
        System.out.println();
        BFS();
    }

    private static void DFS(int idx) {

        System.out.print(idx + " ");
        visited[idx] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[idx][i]) {
                DFS(i);
            }
        }
    }

    private static void BFS() {

        visited = new boolean[n + 1];

        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {

            Integer idx = queue.poll();
            System.out.print(idx + " ");

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }

        }



    }
}
