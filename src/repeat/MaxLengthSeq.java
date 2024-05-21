package repeat;

import java.util.Scanner;

/**
 * 연속부분수열
 */
public class MaxLengthSeq {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(n, k, array);

    }

    private static void solve(int n, int k, int[] array) {

        int lt = 0;

        int answer = 0;
        int count = 0;

        for (int rt = 0; rt < n; rt++) {
            int value = array[rt];

            if (value == 1) {
                answer = Math.max(answer, (rt - lt) + 1);
            }

            else {
                count++;

                if (count > k) {

                    while (array[lt] != 0) {
                        lt++;
                    }
                    count--;
                    lt++;
                }
                answer = Math.max(answer, (rt - lt) + 1);

            }
        }

        System.out.println(answer);

    }


}
