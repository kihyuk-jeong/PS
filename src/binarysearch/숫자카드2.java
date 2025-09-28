package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 숫자카드2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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

    private static void solve(int[] arr, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int value : arr2) {
            map.put(value, 0);
        }

        int[] arr2Copy = Arrays.copyOf(arr2, arr2.length);

        Arrays.sort(arr2);

        for (int target : arr) {
            if (isSearch(target, arr2)) {
                map.put(target, map.getOrDefault(target, 0) + 1);
            }
        }


        for (int value : arr2Copy) {
            System.out.print(map.get(value) + " ");
        }


    }

    private static boolean isSearch(int target, int[] arr2) {

        int lt = 0;
        int rt = arr2.length - 1;

        while (lt <= rt) {

            int midIndex = (lt + rt) / 2;

            if (target == arr2[midIndex]) {
                return true;
            } else if (target < arr2[midIndex]) {
                rt = midIndex - 1;
            } else {
                lt = midIndex + 1;
            }
        }

        return false;

    }

}
