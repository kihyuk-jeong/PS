package repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetCommonValue {

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

        Arrays.sort(array1);
        Arrays.sort(array2);

        ArrayList<Integer> answer = new ArrayList<>();

        while (lt < n && rt < m) {

            if (array1[lt] < array2[rt]) {
                lt++;
            } else if (array1[lt] > array2[rt]) {
                rt++;
            } else {
                answer.add(array1[lt]);
                lt++;
                rt++;
            }
        }

        for (Integer value : answer) {
            System.out.print(value + " ");
        }

    }
}
