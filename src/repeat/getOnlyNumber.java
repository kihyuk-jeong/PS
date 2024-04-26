package repeat;

import java.util.Scanner;

public class getOnlyNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        int answer = solve(input);

        System.out.println(answer);

    }

    public static int solve(String input) {

        StringBuilder builder = new StringBuilder();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char value = input.charAt(i);

            if (value >= 48 && value <= 57) {
                builder.append(value);
            }

        }

        return Integer.parseInt(builder.toString());

    }
}
