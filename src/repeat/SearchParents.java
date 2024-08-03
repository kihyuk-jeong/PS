package repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SearchParents {

    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static Integer[] answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        answer = new Integer[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        DFS(1);

        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);

        }

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
