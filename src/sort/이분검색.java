package sort;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(array, n, m);
    }

    private static void solve(int[] array, int n, int m) {

        Arrays.sort(array);

        int lt = 0;
        int rt = n-1;

        while (lt <= rt) {
            int mid = (lt+rt) / 2;

            if (array[mid] == m) {
                System.out.println(mid + 1);
                break;
            } else if (array[mid] > m) {
                rt = mid-1;
            } else {
                lt = mid+1;
            }
        }

    }
}
