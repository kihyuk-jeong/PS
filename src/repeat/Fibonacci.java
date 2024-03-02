package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        solve(n);

    }

    public static void solve(int n) {

        int[] array = new int[n+1];

        array[1] = 1;
        array[2] = 1;

        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }


        Arrays.stream(array)
                .filter(t -> t != 0)
                .forEach(t -> System.out.print(t + " "));

    }
}
