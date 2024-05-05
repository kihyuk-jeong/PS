package twopointer;

import java.util.Scanner;

/**
 * 투포인터 + 슬라이딩 윈도우
 */
public class 연속부분수열 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(n, m, array);

    }

    private static void solve(int n, int m, int[] array) {

        int lt = 0;
        int rt = 0;

        int sum = array[rt];
        int count = 0;

        while (lt < n && rt < n) {

            if (m > sum) {

                if (rt == n - 1) {
                    break;
                }

                rt++;
                sum += array[rt];
            } else if (m < sum) {
                sum -= array[lt];
                lt++;
            } else {
                count++;
                sum -= array[lt];
                lt++;
            }
        }

        System.out.println(count);

    }
}
