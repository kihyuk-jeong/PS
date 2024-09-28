package recursive.dfs;

import java.util.Scanner;

public class 합이_같은_부분집합 {

    private static int n;
    private static int total = 0;
    private static int[] inputs;
    private static String answer = "NO";

    private static boolean flag = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        inputs = new int[n];

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            total += input;
            inputs[i] = input;
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int index, int sum) {

        if (flag) {
            return;
        }


        if (index == n) {

            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }


        } else {
            dfs(index + 1, sum + inputs[index]);
            dfs(index + 1, sum);
        }

    }

}
