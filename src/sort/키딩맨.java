package sort;

import java.util.Arrays;
import java.util.Scanner;

public class 키딩맨 {

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

        int[] copyArr = Arrays.copyOf(array, n);
        Arrays.sort(array);

        int i;

        int man = 0;
        int friend = 0;

        for (i = 0; i < n; i++) {
            if (array[i] != copyArr[i]) {
                man = i + 1;
                break;
            }
        }

        for (i = i + 1; i < n; i++) {
            if (array[i] != copyArr[i]) {
                friend = i + 1;
                break;
            }
        }

        System.out.print(man + " ");
        System.out.print(friend);

    }
}
