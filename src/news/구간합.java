package news;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 합 배열 공식 : arr[i] = arr[i-1] + s[i]
 * 구간 합 : s[j] - s[i-1]
 */
public class 구간합 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int quiz = sc.nextInt();

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + sc.nextInt();
        }

        // 1 index 를 0인것 처럼 사용해야 한다.
        for (int q = 0; q < quiz; q++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            System.out.println(arr[j] - arr[i - 1]);
        }
    }
}
