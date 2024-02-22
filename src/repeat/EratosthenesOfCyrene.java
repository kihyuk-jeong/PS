package repeat;

import java.util.Scanner;

public class EratosthenesOfCyrene {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(solve(n));

    }

    private static int solve(int n) {

        int[] array = new int[n + 1];

        array[0] = 1;
        array[1] = 1;

        int count = 0;

        for (int i = 2; i < n + 1; i++) {

            if (array[i] == 0) {
                count++;
                for (int j = i + i; j < n + 1; j += i) {
                    array[j] = 1;
                }

            }
        }

        return count;
    }
}
