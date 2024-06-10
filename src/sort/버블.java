package sort;

import java.util.Scanner;

public class 버블 {
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

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }

        }

        for (int value : array) {
            System.out.print(value + " ");
        }

    }
}
