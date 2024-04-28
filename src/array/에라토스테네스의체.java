package array;

import java.util.Scanner;

public class 에라토스테네스의체 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(solve(n));
    }

    public static int solve(int n) {

        int[] primeNumbers = new int[n + 1];
        int count = 0;

        for (int i = 2; i < n + 1; i++) {
            if (primeNumbers[i] == 0) {
                count++;

                for (int j = i; j < n + 1; j += i) {
                    primeNumbers[j] = 1;
                }
            }
        }
        return count;
    }
}