package recursive.dfs;

import java.util.Scanner;

public class 중복순열 {

    private static int n;
    private static int m;

    private static int[] array;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        array = new int[m];

        dfs(0);
    }

    private static void dfs(int L) {

        if (L == m) {
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {

            array[L] = i;
            dfs(L + 1);
        }
    }
}
