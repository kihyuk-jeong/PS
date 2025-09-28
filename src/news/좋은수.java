package news;

/**
 * 1253번 (G4)
 */

import java.util.Arrays;
import java.util.Scanner;

public class 좋은수 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (isGoodNumber(i, arr)) {
                count++;
            }
        }

        System.out.println(count);


    }

    private static boolean isGoodNumber(int targetIndex, int[] arr) {

        int lt = 0;
        int rt = arr.length - 1;
        int target = arr[targetIndex];

        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum == target) {
                if (rt != targetIndex && lt != targetIndex) {
                    return true;
                } else if (rt == targetIndex) {
                    rt--;
                } else {
                    lt++;
                }
            } else if (sum < target) {
                lt++;
            } else {
                rt--;
            }
        }

        return false;

    }
}
