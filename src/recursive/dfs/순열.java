package recursive.dfs;

import java.util.Scanner;

public class 순열 {

    private static int n, m;
    private static int[] numbers;
    private static boolean[] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        checked = new boolean[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }


        dfs(0, new int[m]);

    }

    private static void dfs(int level, int[] answer) {

        if (level == m) {
            for (int number : answer) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!checked[i]) {
                checked[i] = true;
                answer[level] = numbers[i];
                dfs(level + 1, answer);
                checked[i] = false;
            }
        }
    }
}
