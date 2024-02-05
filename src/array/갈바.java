package array;

import java.util.Scanner;

public class 갈바 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        int[] a = new int[tc];
        int[] b = new int[tc];

        for (int i = 0; i < tc; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < tc; i++) {
            b[i] = sc.nextInt();
        }

        solve(a, b, tc);
    }

    public static void solve(int[] a, int[] b, int tc) {

        for (int i = 0; i < tc; i++) {

            if (a[i] == b[i]) {
                System.out.println("D");
            } else if (a[i] == 1 && b[i] == 3) {
                System.out.println("A");
            } else if (a[i] == 2 && b[i] == 1) {
                System.out.println("A");
            } else if (a[i] == 3 && b[i] == 2) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }

    }
}
