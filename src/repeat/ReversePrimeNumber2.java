package repeat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReversePrimeNumber2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        List<Integer> solve = solve(n, array);

        System.out.println(solve);

    }

    private static List<Integer> solve(int n, int[] array) {

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int number = array[i];
            int reverseNumber = 0;

            while (number > 0) {

                int temp = number % 10;
                reverseNumber = reverseNumber * 10 + temp;
                number /= 10;
            }

            if (isFrameNumber(reverseNumber)) {
                answer.add(reverseNumber);
            }
        }
        return answer;
    }

    private static boolean isFrameNumber(int number) {

        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
