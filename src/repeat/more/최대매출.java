package repeat.more;

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

        int sum = init(array, k);
        int answer = sum;
        for (int i = k; i < n; i++) {
            sum += array[i] - array[i - k];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);

    }

    private static int init(int[] array, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += array[i];
        }
        return sum;
    }

}
