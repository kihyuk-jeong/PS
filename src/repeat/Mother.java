package repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mother {

    static int N;
    static boolean [] visited;
    static ArrayList<Integer>[] graph;

    static Integer [] answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        answer = new Integer[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        DFS(1);

        System.out.println(Arrays.toString(answer));

    }

    private static void DFS(int idx) {

        visited[idx] = true;

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);

            if (!visited[next]) {
                answer[next] = idx;
                DFS(next);
            }

        }

    }
}
