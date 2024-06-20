package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 결정 알고리즘ㅇㅁㄴ
 */
public class 뮤직비디오 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int answer = solve(m, array);

        System.out.println(answer);
    }

    private static int solve(int dvdCount, int[] array) {

        int lt = array[array.length - 1];
        int rt = Arrays.stream(array).sum();

        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (getCount(array, mid) <= dvdCount) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    private static int getCount(int[] array, int mid) {

        int sum = 0;
        int count = 1;
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
