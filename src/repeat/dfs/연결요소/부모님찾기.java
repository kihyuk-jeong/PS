package repeat.dfs.연결요소;

import java.util.ArrayList;
import java.util.Scanner;

public class 부모님찾기 {

    private static int n;
    private static int[] answer;
    private static boolean[] visited;

    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        visited = new boolean[n + 1];
        answer = new int[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }

    }

    private static void dfs(int idx) {

        visited[idx] = true;

        for (int i = 0; i < graph[idx].size(); i++) {

            int current = graph[idx].get(i);

            if (!visited[current]) {

                answer[current] = idx;

                dfs(current);

            }
        }
    }

}
