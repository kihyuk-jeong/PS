package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 홀스 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int horse = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        System.out.println(solve(horse, array));
    }

    private static int solve(int horseCount, int[] array) {

        int lt = 1;
        int rt = array[array.length - 1];

        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (getCount(array, mid) >= horseCount) {
                answer = Math.max(mid, answer);
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    private static int getCount(int[] array, int mid) {

        int length = array.length;

        int point = array[0];
        int count = 1;

        for (int i = 1; i < length; i++) {
            if (array[i] - point >= mid) {
                count++;
                point = array[i];
            }
        }

        return count;

    }
}
