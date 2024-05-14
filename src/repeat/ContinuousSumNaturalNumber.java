package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class ContinuousSumNaturalNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        solve(N);

    }

    private static void solve(int n) {

        int length = n / 2 + 1;
        int[] array = createArray(length);

        int sum = 0;
        int count = 0;

        int lt =0;

        for (int rt = 0; rt < length; rt++) {

            sum += array[rt];

            if (sum == n) {
                count++;
            }

            while (sum >= n) {
                sum -= array[lt];
                lt++;

                if (sum == n) {
                    count++;
                }
            }

        }

        System.out.println(count);



    }

    private static int[]  createArray(int length) {
        int[] array = new int[length];

        for (int i = 1; i <= length; i++) {
            array[i-1] = i;
        }

        return array;
    }

}
