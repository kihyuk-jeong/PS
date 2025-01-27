package repeat.more;

import java.util.Arrays;
import java.util.Scanner;

public class 조용필 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int lt = array[0];
        int rt = Arrays.stream(array).sum();

        int answer = Integer.MAX_VALUE;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (get(mid, array) > m) {
                // 크기를 늘려줘야지.
                lt = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                rt = mid - 1;
            }

        }

        System.out.println(answer);


    }

    private static int get(int mid, int[] array) {

        int temp = 1;
        int sum = 0;

        for (int value : array) {

            if (value + sum > mid) {
                temp++;
                sum = value;
            } else {
                sum += value;
            }
        }
        return temp;
    }
}
