package recursive.dfs.soon10;

import java.util.Scanner;

/**
 * 조합
 */
public class 완전노중복순열 {

    private static int n, m;
    private static int[] array;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        array = new int[m];

        dfs(0, 1);
    }

    private static void dfs(int level, int start) {

        if (level == m) {
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {

            array[level] = i;
            dfs(level + 1, i + 1);
        }
    }
}
