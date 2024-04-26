package repeat;

import java.util.Scanner;

public class ValidPelindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.println(solve(input));
    }

    public static String solve(String input) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            char value = input.charAt(i);
            if (Character.isAlphabetic(value)) {
                builder.append(value);
            }

        }
        input = builder.toString().toUpperCase();

        int length = input.length() / 2;

        for (int i = 0; i < length; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return "NO";
            }
        }

        return "YES";

    }

}
