package sort;

import java.util.Arrays;
import java.util.Scanner;

public class 중복확인 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        solve(array, n);
    }

    private static void solve(int[] array, int n) {

        boolean isDup = false;

        for (int i = 0; i < n - 1; i++) {
            if (array[i] == array[i + 1]) {
                isDup = true;
                break;
            }
        }

        System.out.println(isDup ? "D" : "U");

    }
}
