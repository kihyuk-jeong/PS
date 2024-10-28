package recursive.dfs;

import java.util.Scanner;

/**
 * 조합 == 파스칼 삼각형 가중치 ( 어느 숫자가 몇 번 더해져서 마지막 값에 기여하는지를 나타내는 가중치 역할)
 * ex) 1. N 이 5 일 때, 4C0~4C4 까지 가중치를 구함.
 *     2. 순열을 통해 가중치*순열 을 전부 더한 값이 F 인지 확인함
 */

public class 수열_추측하기 {
    private static int n, f;

    private static int[] weights; // 가중치를 담을 배열
    private static int[] permutation;    // 1~4 순열을 담을 배열
    private static boolean[] checked;

    private static boolean flag;

    private static int[][] memo = new int[11][11];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();

        weights = new int[n];
        permutation = new int[n];
        checked = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            weights[i] = comb(n - 1, i);
        }

        dfs(0, 0);
    }

    private static void dfs(int L, int sum) {

        if (flag) {
            return;
        }

        if (L == n) {
            if (sum == f) {
                for (int value : permutation) {
                    System.out.print(value + " ");
                }

                flag = true;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (!checked[i]) {
                checked[i] = true;
                permutation[L] = i;
                dfs(L + 1, sum + permutation[L] * weights[L]);
                checked[i] = false;
            }
        }
    }


    private static int comb(int r, int m) {

        if (memo[r][m] > 0) {
            return memo[r][m];
        }

        if (r == m || m == 0) {
            return 1;
        }

        return memo[r][m] = comb(r - 1, m - 1) + comb(r - 1, m);
    }
}
