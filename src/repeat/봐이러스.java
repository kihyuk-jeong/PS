package repeat;

import java.util.Scanner;

public class 봐이러스 {

    static int N, M;
    static boolean [][] graph;
    static boolean [] visited;

    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);

        System.out.println(answer-1);

    }

    private static void dfs(int idx) {

        System.out.println( " emf" + idx);
        visited[idx] = true;
        answer++;

        for (int i = 1; i <= N; i++) {

            if (!visited[i] && graph[idx][i]) {
                System.out.println(idx + " idx");
                System.out.println(i + " i");
                dfs(i);
            }
        }
    }
}