package repeat.dfs.연결요소;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 깊이우선탐색1 {

    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    private static int u, v, r;
    private static int count = 0;

    private static int[] orders;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        u = sc.nextInt();
        v = sc.nextInt();
        r = sc.nextInt();


        graph = new ArrayList[u + 1];
        visited = new boolean[u + 1];
        orders = new int[u + 1];

        for (int i = 1; i <= u; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= u; i++) {
            Collections.sort(graph[i]);
        }

        dfs(r);

        for (int i = 1; i <= u; i++) {
            System.out.println(orders[i]);
        }

    }

    private static void dfs(int idx) {

        visited[idx] = true;
        count++;
        orders[idx] = count;


        for (int i = 0; i < graph[idx].size(); i++) {

            int value = graph[idx].get(i);

            if (!visited[value]) {
                dfs(value);
            }
        }
    }

}
