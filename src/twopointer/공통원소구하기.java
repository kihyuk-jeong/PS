package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 공통원소구하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] array1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            array1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] array2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            array2[i] = sc.nextInt();
        }

        solve(n1, n2, array1, array2);
    }

    private static void solve(int n1, int n2, int[] array1, int[] array2) {

        Arrays.sort(array1);
        Arrays.sort(array2);

        int p1 = 0;
        int p2 = 0;

        ArrayList<Integer> answer = new ArrayList<>();

        while (p1 < n1 && p2 < n2) {

            if (array1[p1] < array2[p2]) {
                p1++;
            } else if (array1[p1] > array2[p2]) {
                p2++;
            } else {
                answer.add(array1[p1]);
                p1++;
                p2++;
            }

        }

        for (Integer value : answer) {
            System.out.print(value + " ");
        }

    }


}
