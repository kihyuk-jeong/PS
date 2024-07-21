package repeat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DeppFirstSearchOne {

    static int n,m,r;
    static int order;
    static int answer[];
    static ArrayList<Integer>[] arrayList;
    static boolean [] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        visited = new boolean[n + 1];
        answer = new int[n + 1];
        arrayList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            arrayList[x].add(y);
            arrayList[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arrayList[i]);
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

        for (int i = 0; i < arrayList[idx].size(); i++) {

            int next = arrayList[idx].get(i);

            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
