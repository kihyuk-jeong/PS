package repeat;

import java.util.Scanner;

public class SamePartSum {

    private static int n, total;
    private static int[] array;
    private static boolean flag;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        array = new int[n];
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            array[i] = value;
            total += value;
        }


        dfs(0, 0);

        System.out.println(flag ? "YES" : "NO");
    }

    private static void dfs(int level, int sum) {

        if (flag) {
            return;
        }

        if (level == n) {

            if ((total - sum) == sum) {
                flag = true;
            }
            return;
        }

        for (int i = level; i < n; i++) {
            dfs(i + 1, sum + array[i]);
            dfs(i + 1, sum);
        }
    }
}
