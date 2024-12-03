package repeat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coin {

    private static int answer = Integer.MAX_VALUE;
    private static int n,m;
    private static Integer [] coins;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coins = new Integer[n];


        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins, Collections.reverseOrder());

        m = sc.nextInt();

        dfs(0, 0);

        System.out.println(answer);

    }

    private static void dfs(int level, int sum) {

        if (sum > m) {
            return;
        }

        if (level >= answer) {
            return;
        }


        if (sum == m) {
            answer = level;
        }

        for (int i = 0; i < n; i++) {
            dfs(level + 1, sum + coins[i]);
        }



    }
}