package recursive.dfs;

import java.util.Scanner;

public class 말단_경로_DFS_FAIL {

    static boolean[][] graph;
    static boolean[] visited;
    static int level;
    static int answer = Integer.MAX_VALUE;

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 개수
        n = sc.nextInt();

        // 정점
        m = sc.nextInt();

        graph = new boolean[m + 1][m + 1];
        visited = new boolean[m + 1];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        for (int i = 1; i <= m; i++) {

            if (!visited[i]) {
//                level = 0;
                dfs(i);
//                System.out.println(level);
            }

//            answer = Math.min(answer, level);
        }

//        System.out.println(answer);
    }

    private static void dfs(int idx) {

        visited[idx] = true;

        for (int i = 1; i <= m; i++) {

            if (!visited[i] && graph[idx][i]) {

                System.out.println("idx : " + idx + " , " + "i : " + i);

                level++;
                dfs(i);
            }
        }

    }
}
