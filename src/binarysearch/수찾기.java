package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        int m = sc.nextInt();
        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        int[] answers = solve(array, targets);

        for (int answer : answers) {
            System.out.println(answer);
        }

    }

    private static int[] solve(int[] array, int[] targets) {

        int m = targets.length;

        int[] answers = new int[m];

        for (int i = 0; i < m; i++) {
            int target = targets[i];
            if (isExist(target, array)) {
                answers[i] = 1;
            } else {
                answers[i] = 0;
            }
        }
        return answers;
    }

    private static boolean isExist(int target, int[] array) {

        int lt = 0;
        int rt = array.length - 1;

        while (lt <= rt) {
            int midIndex = (lt + rt) / 2;
            int mid = array[midIndex];

            if (target == mid) {
                return true;
            }

            if (target < mid) {
                rt = midIndex - 1;
            } else {
                lt = midIndex + 1;
            }

        }
        return false;
    }

}
