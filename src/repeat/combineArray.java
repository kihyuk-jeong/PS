package repeat;

import java.util.ArrayList;
import java.util.Scanner;

public class combineArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();

        int[] array1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            array1[i] = scanner.nextInt();
        }

        int n2 = scanner.nextInt();

        int[] array2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            array2[i] = scanner.nextInt();
        }

        solve(array1, array2, n1, n2);
    }

    private static void solve(int[] array1, int[] array2, int n1, int n2) {

        int p1 = 0;
        int p2 = 0;

        ArrayList<Integer> answer = new ArrayList<>();

        while (p1 < n1 && p2 < n2) {

            if (array1[p1] < array2[p2]) {
                answer.add(array1[p1++]);
            } else {
                answer.add(array2[p2++]);
            }
        }

        for (int i = p1; i < n1; i++) {
            answer.add(array1[i]);
        }

        for (int i = p2; i < n2; i++) {
            answer.add(array2[i]);
        }

        for (Integer value : answer) {
            System.out.print(value + " ");
        }

    }
}
