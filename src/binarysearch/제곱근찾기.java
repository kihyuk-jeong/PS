package binarysearch;

import java.util.Scanner;

public class 제곱근찾기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long answer = solve(n);

        System.out.println(answer);
    }

    private static long solve(long n) {

        if (n == 0) {
            return 0;
        }

        long lt = 0;
        long rt = n;
        long answer = 0;

        while (lt <= rt) {
            long mid = lt + (rt - lt) / 2;

            if (mid <= n / mid) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

        }

        return answer * answer == n ? answer : answer + 1;
    }
}
