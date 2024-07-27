package recursive.dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class 깊이우선탐색2 {

    static int n,m,r;
    static int order;
    static int [] answer;
    static boolean [] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        answer = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        // 리스트 배열 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.reverseOrder());
        }

        dfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }

    }

    private static void dfs(int idx) {

        visited[idx] = true;
        order++;
        answer[idx] = order;

        for (int i = 0; i < graph[idx].size(); i++) {

            int next = graph[idx].get(i);

            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
