package recursive.dfs;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class 깊이우선탐색1_fail {

    static int n, m, r;
    static boolean [][] array;
    static boolean [] visited;
    static Set<Integer> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 점
        n = sc.nextInt();

        // 선
        m = sc.nextInt();

        // 시작점
        r = sc.nextInt();

        array = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            array[x][y] = true;
            array[y][x] = true;
        }

        DFS(r);

        for (Integer value : set) {
            System.out.println(value);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && !set.contains(i)) {
                System.out.println(0);
            }
        }

    }

    private static void DFS(int idx) {

        visited[idx] = true;
        set.add(idx);

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && array[idx][i]) {
                DFS(i);
            }
        }
    }
}
