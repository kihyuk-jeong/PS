package repeat;

import java.util.Scanner;

public class 연요 {

    static int N, M;
    static boolean[] visited;
    static boolean[][] graph;
    static int answer;

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
            graph[y][x] = true;
        }

        for (int i = 1; i <= N; i++) {

            if (!visited[i]) {
                DFS(i);
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static void DFS(int idx) {

        visited[idx] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[idx][i]) {
                DFS(i);
            }
        }
    }
}
