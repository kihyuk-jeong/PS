package repeat;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoArraySum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array1 = new int[n];

        for (int i = 0; i < n; i++) {
            array1[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int[] array2 = new int[m];

        for (int i = 0; i < m; i++) {
            array2[i] = sc.nextInt();
        }

        solve(n, array1, m, array2);

    }

    private static void solve(int n, int[] array1, int m, int[] array2) {

        int lt = 0;
        int rt = 0;

        ArrayList<Integer> answer = new ArrayList<>();

        while (lt < n && rt < m) {

            if (array1[lt] < array2[rt]) {
                answer.add(array1[lt++]);
            } else {
                answer.add(array2[rt++]);
            }
        }


        if (lt != n) {
            for (int i = lt; i < n; i++) {
                answer.add(array1[i]);
            }
        }

        if (rt != m) {
            for (int i = rt; i < m; i++) {
                answer.add(array2[i]);
            }
        }

        for (Integer value : answer)  {
            System.out.print(value + " ");
        }
    }
}
