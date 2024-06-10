package sort;

import java.util.Arrays;
import java.util.Scanner;

public class 삽입 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(array, n);
    }

    private static void solve(int[] array, int n) {

        for (int i = 1; i < n; i++) {
            int temp = array[i];

            int j;

            for (j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = temp;
        }

        System.out.println(Arrays.toString(array));

    }

}
