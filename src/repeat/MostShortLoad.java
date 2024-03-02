package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class MostShortLoad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        String target = sc.next();

        solve(input, target);
    }

    public static void solve(String input, String target) {

        int count = 100;
        int length = input.length();
        char charTarget = target.charAt(0);
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == charTarget) {
                count = 0;
            } else {
                count++;
            }
            answer[i] = count;
        }

        count = 100;

        for (int i = length - 1; i >= 0; i--) {
            if (input.charAt(i) == charTarget) {
                count = 0;
            } else {
                count++;
                answer[i] = Math.min(answer[i], count);

            }

        }

        for (int result : answer) {
            System.out.print(result + " ");
        }

    }
}
