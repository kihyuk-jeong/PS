package twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class 두배열합치기 {

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

        solve(array1, array2, n1, n2);

    }

    private static void solve(int[] array1, int[] array2, int n1, int n2) {

        int p1 = 0;
        int p2 = 0;

        StringBuilder answer = new StringBuilder();

        while (p1 != n1 && p2 != n2) {


            if (array1[p1] < array2[p2]) {
                answer.append(array1[p1]).append(" ");
                p1++;
            } else if (array1[p1] > array2[p2]) {
                answer.append(array2[p2]).append(" ");
                p2++;
            } else {
                answer.append(array1[p1]).append(" ");
                answer.append(array2[p2]).append(" ");
                p1++;
                p2++;
            }
        }

        if (p1 == n1) {
            for (int i = p2; i < n2; i++) {
                answer.append(array2[i]).append(" ");
            }
        } else {
            for (int i = p1; i < n1; i++) {
                answer.append(array1[i]).append(" ");
            }
        }

        System.out.println(answer);

    }
}