package repeat.dfs;

import java.util.Scanner;

public class 댕댕이탑승 {

    private static int limit, n;

    private static int [] weight;

    private static int maxWeight = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        limit = sc.nextInt();
        n = sc.nextInt();
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        dfs(0, 0);

        System.out.println(maxWeight);
    }

    private static void dfs(int startIndex, int sum) {

        if (limit < sum) {
            return;
        }

        maxWeight = Math.max(maxWeight, sum);

        for (int i = startIndex; i < n; i++) {
            dfs(i + 1, sum + weight[i]);
        }


    }
}
