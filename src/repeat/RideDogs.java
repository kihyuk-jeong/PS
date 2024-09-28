package repeat;

import java.util.Scanner;

public class RideDogs {

    private static int n;
    private static int[] numbers;
    private static int answer = Integer.MIN_VALUE;
    private static int limit;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        limit = sc.nextInt();
        n = sc.nextInt();

        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        recur(0, 0);

        System.out.println(answer);
    }

    private static void recur(int sum, int start) {

        if (sum > limit) {
            return;
        }

        answer = Math.max(answer, sum);

        for (int i = start; i < n; i++) {
            recur(sum + numbers[i], i + 1);
        }
    }
}
