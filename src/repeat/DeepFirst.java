package repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DeepFirst {

    static int N, M, R;
    static int order;
    static boolean[] visited;
    static int[] answer;
    static ArrayList<Integer>[] arrayLists;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 정점
        N = sc.nextInt();

        // 간선
        M = sc.nextInt();

        // 출발점
        R = sc.nextInt();

        answer = new int[N + 1];
        arrayLists = new ArrayList[100001];
        visited = new boolean[N + 1];


        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrayLists[x].add(y);
            arrayLists[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arrayLists[i]);
        }


        DFS(R);

        System.out.println(Arrays.toString(answer));
    }

    private static void DFS(int idx) {

        visited[idx] = true;
        order++;
        answer[idx] = order;


        for (int i = 0; i < arrayLists[idx].size(); i++) {
            int next = arrayLists[idx].get(i);

            if (!visited[next]) {
                DFS(next);
            }


        }


    }

}
