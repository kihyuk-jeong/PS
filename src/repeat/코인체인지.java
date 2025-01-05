package repeat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 코인체인지 {

    private static int n, target;
    private static Integer[] coins;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coins = new Integer[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        target = sc.nextInt();

        Arrays.sort(coins, Collections.reverseOrder());

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int level, int sum) {

        if (level >= answer) {
            return;
        }

        if (sum > target) {
            return;
        }

        if (sum == target) {
            answer = level;
        }

        for (int i = 0; i < n; i++) {
            dfs(level + 1, sum + coins[i]);
        }
    }
}
