package recursive.dfs;

import java.util.Scanner;

/**
 * 연결 요소의 개수 (백준 11724)
 */
public class 연결요쇼의개수 {

    static boolean[][] array;
    static boolean[] visited;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int answer = 0;
        array = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            array[x][y] = true;
            array[y][x] = true;

        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                DFS(i);
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static void DFS(int idx) {

        visited[idx] = true;

        for (int i = 1; i <= n; i++) {

            if (!visited[i] && array[idx][i]) {
                DFS(i);
            }

        }


    }

}
