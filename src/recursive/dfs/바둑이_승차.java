package recursive.dfs;

import java.util.Scanner;

public class 바둑이_승차 {

    private static int max, n;
    private static int[] dogs;
    private static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        max = sc.nextInt();
        n = sc.nextInt();

        dogs = new int[n];

        for (int i = 0; i < n; i++) {
            dogs[i] = sc.nextInt();
        }
        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int index, int sum) {

        if (max < sum) {
            return;
        }

        if (index == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(index + 1, sum + dogs[index]);
            dfs(index + 1, sum);
        }
    }
}
