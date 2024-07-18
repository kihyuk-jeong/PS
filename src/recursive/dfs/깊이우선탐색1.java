package recursive.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class 깊이우선탐색1 {

    static int n, m, r;

    static int order;
    static boolean[] visited;
    static int[] answer;
    static ArrayList<Integer>[] array;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 점
        n = sc.nextInt();

        // 선
        m = sc.nextInt();

        // 시작점
        r = sc.nextInt();

        visited = new boolean[n + 1];
        answer = new int[n + 1];


        array = new ArrayList[100001];

        for (int i = 1; i <= n; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            array[x].add(y);
            array[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(array[i]);
        }

        DFS(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }

    }

    public static void DFS(int idx) {

        visited[idx] = true;
        order++;
        answer[idx] = order;

        for (int i = 0; i < array[idx].size(); i++) {
            int next = array[idx].get(i);

            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
