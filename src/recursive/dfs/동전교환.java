package recursive.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전교환 {

    private static int n;
    private static Integer[] array;
    private static int count;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        array = new Integer[n];


        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array, Collections.reverseOrder());

        count = sc.nextInt();

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int L, int sum) {
        if (sum > count) {
            return;
        }

        if (L >= answer) {
            return;
        }

        if (sum == count) {
            answer = L;
            return;
        }

        for (int i = 0; i < n; i++) {
            dfs(L + 1, sum + array[i]);
        }


    }
}
