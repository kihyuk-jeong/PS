package sort;

/**
 * mid 값이 가장 가까운 말의 거리라고 가정 하고 풀면 될듯.
 */

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        solve(n, m, array);
    }

    private static void solve(int n, int m, int[] array) {

        int answer = 0;
        int lt = 1;
        int rt = array[array.length - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (getHorseCount(array, mid) >= m) {
                answer = Math.max(answer, mid);
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static int getHorseCount(int[] array, int max) {

        int length = array.length;
        int point = array[0];

        // 시작 시점에 point 에 말 1마리를 배치하고 시작
        int count = 1;

        for (int i = 1; i < length; i++) {
            if (array[i] - point >= max) {
                count++;
                point = array[i];
            }
        }
        return count;
    }
}
