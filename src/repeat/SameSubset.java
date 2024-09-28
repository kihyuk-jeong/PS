package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class SameSubset {

    private static String answer = "NO";
    private static int[] numbers;
    private static int n;

    private static int total;
    private static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        total = Arrays.stream(numbers).sum();

        recursive(0, 0);

        System.out.println(answer);
    }

    private static void recursive(int sum, int start) {

        if ((total - sum) == sum) {
            answer = "YES";
        } else {

            for (int i = start; i < n; i++) {
                recursive(sum + numbers[i], i+1);
                recursive(sum, i+1);
            }

        }

    }
}
