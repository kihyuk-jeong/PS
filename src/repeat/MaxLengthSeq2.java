package repeat;

import java.util.Scanner;

public class MaxLengthSeq2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(array, n, k);
    }

    private static void solve(int[] array, int n, int k) {

        int lt = 0;
        int count = 0;
        int answer = 0;

        for (int rt = 0; rt < n; rt++) {

            if (array[rt] == 0) {
                count++;
            }

            while (count > k) {

                if (array[lt] == 0) {
                    count--;
                }

                lt++;
            }

            answer = Math.max(answer, (rt - lt) + 1);

        }

        System.out.println(answer);

    }
}
