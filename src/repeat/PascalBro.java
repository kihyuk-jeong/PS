package repeat;

import java.util.Scanner;

/**
 * 1. 1 부터 N 까지의 가중치를 구한다 (조합)
 * 2. 1 부터 N 까지 중복순열을 모두 구한다.
 * 3. (가중치 * 순열) 을 전부 구해서 M 이 나오는지 확인한다.
 */
public class PascalBro {

    private static int n, m;
    private static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[] weight = new int[n];
        int[] array = new int[n];


        for (int i = 0; i < n; i++) {
            weight[i] = getWeight(new int[11][11], n - 1, i);
        }

        dfs(weight, array, 0, 0, new boolean[n+1]);


    }

    private static void dfs(int[] weight, int[] array, int sum, int level, boolean[] used) {

        if (flag) {
            return;
        }

        if (level == n) {

            if (sum == m) {
                for (int value : array) {
                    System.out.print(value + " ");
                    flag = true;
                }

            }
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (!used[i]) {
                used[i] = true;
                array[level] = i;
                dfs(weight, array, (sum + (weight[level] * array[level])), level + 1, used);
                used[i] = false;
            }
        }

    }

    private static int getWeight(int[][] temp, int n, int r) {

        if (temp[n][r] > 0) {
            return temp[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        }

        return temp[n][r] = getWeight(temp, n - 1, r - 1) + getWeight(temp, n - 1, r);


    }


}
