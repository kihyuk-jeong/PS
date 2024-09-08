package recursive.dfs;

import java.util.Scanner;

public class 경로탐색 {

    static boolean [] visited;
    static boolean [][] graph;

    static int N, M;

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
        }

        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int idx) {

        if (idx == N) {
            System.out.println(idx);
            count++;
        }

        visited[idx] = true;

        for (int i = 1; i <= N; i++) {

            if (!visited[i] && graph[idx][i]) {
                dfs(i);
                visited[i] = false;
            }

        }


    }


}
