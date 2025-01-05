package repeat;

import java.util.Scanner;

public class 수측 {

    private static int[] memorial;
    private static int n, m;
    private static boolean [] used;
    private static boolean flag;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        memorial = new int[n];
        used = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            memorial[i] = comb(n - 1, i, new int[n][n]);
        }

        dfs(0, 0, new int[n]);
    }

    private static void dfs(int level, int sum, int[] arr) {

        if (flag) {
            return;
        }

        if (level == n) {

            if (sum == m) {
                flag = true;

                for (int value : arr) {
                    System.out.print(value + " ");
                }
            }
            return;

        }

        // 수열을 1부터 n 순서로 나열하기 때문에 사전순 정렬이 따로 필요 없음.
        for (int i = 1; i <= n; i++) {

            if (!used[i]) {
                used[i] = true;
                arr[level] = i;
                dfs(level + 1, sum + (memorial[level] * arr[level]), arr);
                used[i] = false;
            }
        }
    }


    private static int comb(int c, int r, int[][] temp) {

        if (temp[c][r] > 0) {
            return temp[c][r];
        }

        if (r == 0 || c == r) {
            return 1;
        }

        return temp[c][r] = comb(c - 1, r - 1, temp) + comb(c - 1, r, temp);
    }
}
