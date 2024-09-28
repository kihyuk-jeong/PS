package recursive.dfs;

import java.util.Scanner;

public class 부분_집합_구하기 {

    private static int n;
    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        visited = new boolean[n + 1];

        dfs(1);
    }

    private static void dfs(int idx) {

        if (idx == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {

            visited[idx] = true;
            dfs(idx + 1);
            visited[idx] = false;
            dfs(idx + 1);
        }

    }

}
