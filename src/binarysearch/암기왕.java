package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 동규가 못믿음
 * 연종이가 본 정수들을 수첩 1에 적어놓음
 * 동규는 연종이에게 M 개의 질문을 함.
 * 질문의 내용은, X 라는 정수를 오늘 본 적이 있는가 ?
 * 동규는 연종이 봤다고 주장하는 수를 [수첩2] 개 적어둠
 * -> 즉, 수첩1은 연종이가 실제로 본 값, 수첩2는 연종이가 대답한 값
 */

public class 암기왕 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int m = sc.nextInt();
            int[] arr2 = new int[m];

            for (int i = 0; i < m; i++) {
                arr2[i] = sc.nextInt();
            }

            solve(arr, arr2);

        }


    }

    private static void solve(int[] arr, int[] arr2) {

        Arrays.sort(arr);

        for (int target : arr2) {

            if (isSearch(target, arr)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

    private static boolean isSearch(int target, int[] arr) {

        int lt = 0;
        int rt = arr.length - 1;

        while (lt <= rt) {
            int midIndex = (lt + rt) / 2;

            if (arr[midIndex] == target) {
                return true;
            } else if (arr[midIndex] > target) {
                rt = midIndex - 1;
            } else {
                lt = midIndex + 1;
            }
        }
        return false;
    }

}
