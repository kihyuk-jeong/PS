package repeat.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/24479
 * 22479, 22480 동일한 문제 (내림차순 정렬, 오름차순 정렬 차이)
 */
public class 깊이_우선_탐색_1 {

    static int N,M,R;
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static int [] order;
    static int answer = 0;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            // 올림차순
            Collections.sort(graph[i]);

            // 내림차순
            // graph[i].sort(Collections.reverseOrder());

        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    private static void dfs(int idx) {

        answer++;
        order[idx] = answer;

        visited[idx] = true;

        for (int i = 0; i < graph[idx].size(); i++) {
            Integer next = graph[idx].get(i);

            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
