package news;

// 10986번 (구간합 응용)
/**
 * 구간합의 원리 (S = 구간합 배열)
 * S[i] - S[j] 의 값은 원본 배열의 j+1 ~ i 까지의 합과 동일하다.
 */

import java.util.Scanner;

public class 나머지_합_구하기 {

    private static int[][] memo;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n + 1];
        int[] comb = new int[m];

        // memo = new int[n+1][3];

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + sc.nextInt();
        }

        // 1. 합배열을 M 으로 나누기 연산
        for (int i = 1; i <= n; i++) {
            int value = arr[i] % m;

            if (value == 0) {
                answer++;
            }
            comb[value]++;
        }

        // 조합 구하는 식..
        for (int i = 0; i < m; i++) {
            answer += (comb[i] * (comb[i] - 1)) / 2;
        }

        // for (int i = 0; i < m; i++) {
        //
        //     if (comb[i] != 0) {
        //         answer += getComb(comb[i], 2);
        //     }
        // }

        System.out.println(answer);
    }

    // private static int getComb(int r, int n) {
    //
    //     if (r == n || n == 0) {
    //         return 1;
    //     }
    //
    //     if (memo[r][n] != 0) {
    //         return memo[r][n];
    //     }
    //
    //     return getComb(r - 1, n - 1) + getComb(r - 1, n);
    // }

}
