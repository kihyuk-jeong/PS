package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class MusicIs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        int answer = Integer.MAX_VALUE;

        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            if (isPossible(arr, mid, m)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }

        }

        System.out.println(answer);

    }

    private static boolean isPossible(int[] arr, int mid, int m) {

        int sum = 0;
        int count = 0;
        for (int value : arr) {

            if (sum + value > mid) {
                sum = value;
                count++;
            } else {
                sum += value;
            }
        }

        if (sum > 0) {
            count++;
        }

        return count <= m;
    }
}
