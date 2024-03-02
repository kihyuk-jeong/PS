package repeat;

import java.util.Scanner;

public class VisibleStudent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solve(n, array));
    }

    public static int solve(int n, int[] array) {

        int max = array[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int value = array[i];
            if (max < value) {
                max = value;
                count++;
            }

        }

        return count;

    }

}
