package slidingwindow;

import java.util.Scanner;

public class 최대매출 {

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

        int answer;
        int sum = 0;

        int position = k;

        for (int i = 0; i < k; i++) {
            sum += array[i];
        }

        answer = sum;

        while (position < n) {
            sum+= (array[position] - array[position - k]);
            answer = Math.max(answer, sum);

            position++;

        }
        System.out.println(answer);
    }
}
