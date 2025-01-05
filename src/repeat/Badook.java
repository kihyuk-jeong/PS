package repeat;

import java.util.Scanner;

public class Badook {

    private static int[] arr;
    private static int limit,n;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        limit = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // sum, level
        dfs2(0,0);

        System.out.println(answer);
    }

    private static void dfs(int sum, int level) {

        if (limit < sum) {
            return;
        }

        if (level == n) {
            answer = Math.max(answer, sum);
            return;
        }

        dfs(sum + arr[level], level + 1);
        dfs(sum, level + 1);
    }

    private static void dfs2(int start, int sum) {

        if (limit < sum) {
            return;
        }

        answer = Math.max(answer, sum);

        for (int i = start; i < n; i++) {
            dfs2(i + 1, sum + arr[i]);
        }


    }
}
