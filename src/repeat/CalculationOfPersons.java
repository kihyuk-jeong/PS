package repeat;

import java.util.Scanner;

public class CalculationOfPersons {

    static int n, person1, person2, m;
    static int answer = -1;
    static boolean[][] graph;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        person1 = sc.nextInt();
        person2 = sc.nextInt();
        m = sc.nextInt();

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(person1, 0);

        System.out.println(answer);
    }

    private static void dfs(int idx, int count) {

        visited[idx] = true;

        if (idx == person2) {
            answer = count;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[idx][i]) {
                dfs(i, count+1);
            }
        }



    }




}
