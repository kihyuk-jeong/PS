package repeat.more;

import java.util.Arrays;
import java.util.Scanner;

public class 가왕 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = arr[0];
        int rt = Arrays.stream(arr).sum();

        int answer = Integer.MAX_VALUE;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = getCount(mid, arr);

            if (count > m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        System.out.println(answer);

    }

    private static int getCount(int mid, int[] arr) {

        int sum = 0;
        int count = 1;

        for (int value : arr) {

            if (sum + value > mid) {
                sum = value;
                count++;
            } else {
                sum += value;
            }
        }

        return count;

    }
}
