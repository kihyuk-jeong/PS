package repeat;

import java.util.Scanner;

public class MaximumSales {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        solve(N, K, array);

    }

    private static void solve(int n, int k, int[] array) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += array[i];
        }

        int answer = sum;

        int length = array.length;

        for (int i = k; i < length; i++) {
            sum += array[i] - array[i - k];
            answer = Math.max(answer, sum);

        }
        System.out.println(answer);
    }
}
