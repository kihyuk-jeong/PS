package recursive.dfs;

import java.util.Scanner;

public class 조합의_경우수 {

    private static int[][] memo = new int[34][34];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int answer = dfs(n, m);

        System.out.println(answer);
    }

    private static int dfs(int n, int m) {

        if (memo[n][m] > 0) {
            return memo[n][m];
        }

        if (n == m || m == 0) {
            return 1;
        } else {
            return memo[n][m] = dfs(n - 1, m - 1) + dfs(n - 1, m);
        }

    }
}
