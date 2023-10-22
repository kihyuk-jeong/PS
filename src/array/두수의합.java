package array;

import java.util.Scanner;

//https://www.acmicpc.net/problem/3273
public class 두수의합 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        boolean[] existArray = new boolean[1000001];
        for (int i = 0; i < n; i++) {
            existArray[array[i]] = true;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int value = x - array[i];

            if (0 <= value && value <= 1000000) {
                result += existArray[value] ? 1 : 0;
            }
        }

        System.out.println(result / 2);
    }
}
