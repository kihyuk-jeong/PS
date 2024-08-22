package repeat.dfs;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2644
 */
public class 촌수_계산 {

    static int n, m, x, y, count, answer;

    static boolean [][] graph;
    static boolean [] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        m = sc.nextInt();

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        answer = -1;
        count = 0;
        dfs(x);

        System.out.println(answer);
    }

    private static void dfs(int idx) {

        visited[idx] = true;

        if (idx == y) {
            answer = count;
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (!visited[i] && graph[idx][i]) {
                count++;
                dfs(i);
                count--;
            }

        }



    }



}
