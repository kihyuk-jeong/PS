package repeat.dfs;

import java.util.Scanner;

public class 파스칼삼각형 {

    private static int n, f;
    private static int[] weight;
    private static boolean[] checked;
    private static int[] array;

    private static boolean flag = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();

        // 가중치
        weight = new int[n + 1];

        // 중복 순열 체크
        checked = new boolean[n + 1];

        // 순열
        array = new int[n];


        for (int i = 0; i < n; i++) {
            weight[i] = comb(new int[11][11], n - 1, i);
        }


        dfs(0, 0);


    }

    private static int comb(int[][] temp, int x, int r) {

        if (temp[x][r] > 0) {
            return temp[x][r];
        }

        if (x == r || r == 0) {
            return 1;
        }

        return temp[x][r] = comb(temp, x - 1, r - 1) + comb(temp, x - 1, r);
    }

    private static void dfs(int level, int sum) {

        if (flag) {
            return;
        }

        if (level == n) {
            if (sum == f) {
                flag = true;
                for (int value : array) {
                    System.out.print(value + " ");
                }
                return;

            }

        }

        for (int i = 1; i <= n; i++) {

            if (!checked[i]) {
                checked[i] = true;
                array[level] = i;
                dfs(level + 1, sum + (weight[level] * array[level]));
                checked[i] = false;
            }
        }

    }
}
