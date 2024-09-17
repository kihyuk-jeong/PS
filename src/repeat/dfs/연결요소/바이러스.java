package repeat.dfs.연결요소;

import java.util.Scanner;

public class 바이러스 {
    static boolean [] visited;
    static boolean [][] graph;
    static int n,m;

    static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 정점의 갯수
        n = sc.nextInt();

        // 간선의 갯수
        m = sc.nextInt();

        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);

        System.out.println(answer);
    }

    private static void dfs(int idx) {

        visited[idx] = true;

        for (int i = 1; i <= n; i++) {

            if (!visited[i] && graph[idx][i]) {
                dfs(i);
                answer++;
            }

        }

    }


}
