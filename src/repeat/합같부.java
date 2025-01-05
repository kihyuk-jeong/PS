package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class 합같부 {

    private static String answer = "NO";
    private static int n;
    private static int[] arr;
    private static boolean flag;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int total = Arrays.stream(arr).sum();

        dfs(0, 0, total);

        System.out.println(answer);

    }

    private static void dfs(int sum, int level, int total) {

        if (flag) {
            return;
        }

        if (level == n) {

            if (total - sum == sum) {
                answer = "YES";
                flag = true;
            }
            return;
        }

        dfs(sum + arr[level], level + 1, total);
        dfs(sum, level + 1, total);
    }

}
