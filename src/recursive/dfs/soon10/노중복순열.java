package recursive.dfs.soon10;

import java.util.Scanner;

public class 노중복순열 {

    private static int n, m;
    private static int[] array;
    private static boolean[] checked;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        array = new int[m];
        checked = new boolean[n + 1];


        dfs(0);
    }

    private static void dfs(int level) {

        if (level == m) {
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        // 첫번쨰 포문에 1이 들어감 1 트루  -> 첫
        // 세번쨰 포문에 3
        for (int i = 1; i <= n; i++) {

            if (!checked[i]) {
                checked[i] = true;
                array[level] = i;
                dfs(level+1);
                checked[i] = false;
            }
        }
    }



}
