package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class 트리의_부모_찾기 {

    static int N;
    static boolean[] visited;
    static boolean[][] graph;

    static Integer[] answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        visited = new boolean[N + 1];
        graph = new boolean[N + 1][N + 1];
        answer = new Integer[N + 1];
        for (int i = 0; i < N - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);

        System.out.println(Arrays.toString(answer));
    }

    private static void dfs(int idx) {

        visited[idx] = true;

        for (int i = 1; i <= N; i++) {

            if (!visited[i] && graph[idx][i]) {

                if (answer[i] == null) {
                    answer[i] = idx;
                }
                dfs(i);
            }
        }
    }
}
