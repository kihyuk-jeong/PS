package sort;

import java.util.Scanner;

/**
 * 2 중 포문을 기본으로 함
 * index 는 첫 for 문의 시작점으로 설정하고, 두 번째 for 문을 돌면서 가장 작은 값이 있는 index 로 갱신함
 * 갱신이 끝나면 (2중 포문이 끝나면) index 와 첫 번째 포문의 시작점의 값을 swap 함
 */

public class 선택 {

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

        for (int i = 0; i < n; i++) {

            int index = i;

            for (int j = i + 1; j < n; j++) {

                if (array[index] > array[j]) {
                    index = j;
                }
            }

            // swap
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }


        for (int value : array) {
            System.out.print(value + " ");
        }

    }

}
