package repeat.dfs.연결요소;

import java.util.Scanner;

public class 연결요소의개수 {

    private static boolean [] visited;
    private static boolean [][] graph;
    private static int n;

    private static int answer = 0;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int idx) {

        visited[idx] = true;

        for (int i = 1; i <= n; i++) {

            if (!visited[i] && graph[idx][i]) {
                dfs(i);
            }

        }


    }
}
