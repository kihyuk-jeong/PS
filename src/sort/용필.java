package sort;

import java.util.Arrays;
import java.util.Scanner;

public class 용필 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        solve(array, m);
    }

    private static void solve(int[] array, int dvdCount) {

        int answer = Integer.MAX_VALUE;
        int lt = array[array.length-1];
        int rt = Arrays.stream(array).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (getCount(array, mid) <= dvdCount) {
                answer = Math.min(answer, mid);
                rt = mid -1;
            } else {
                lt = mid+1;
            }
        }

        System.out.println(answer);
    }

    private static int getCount(int[] array, int mid) {

        int count = 1;
        int sum = 0;

        for (int value : array) {
            if (sum + value > mid) {
                count++;
                sum = 0;
            }
            sum += value;
        }
        return count;
    }
}
