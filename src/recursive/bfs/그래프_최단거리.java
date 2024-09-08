package recursive.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그래프_최단거리 {

    static int N,M;
    static int [] answer;
    static boolean [] visited;

    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }


        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i < M; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            graph.get(x).add(y);

        }

        bfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void bfs(int v) {

        answer[v] = 0;
        queue.offer(v);

        while (!queue.isEmpty()) {

            Integer cv = queue.poll();

            int length = graph.get(cv).size();

            for (int i = 0; i < length; i++) {
                Integer nv = graph.get(cv).get(i);

                if (!visited[nv]) {
                    visited[nv] = true;
                    queue.offer(nv);
                    answer[nv] = answer[cv] + 1;
                }

            }
        }
    }

}
