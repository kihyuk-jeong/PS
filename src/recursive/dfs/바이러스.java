package recursive.dfs;

import java.util.Scanner;

public class 바이러스 {

    static boolean[][] computer;
    static boolean[] visited;
    static int n, m;
    static int answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        computer = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            computer[x][y] = true;
            computer[y][x] = true;
        }


        DFS(1);
        System.out.println(answer - 1);


    }

    private static void DFS(int idx) {
        visited[idx] = true;
        answer++;

        for (int i = 1; i <= n; i++) {

            if (!visited[i] && computer[idx][i]) {
                DFS(i);
            }

        }

    }
}
