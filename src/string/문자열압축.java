package string;

import java.util.Scanner;

public class 문자열압축 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        System.out.println(solve(input));

    }

    private static String solve(String input) {

        int length = input.length();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int count = 1;

            for (int j = i + 1; j < length; j++) {

                if (input.charAt(i) == input.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }

            if (count > 1) {
                i += count - 1;
                builder.append(input.charAt(i));
                builder.append(count);
            } else {
                builder.append(input.charAt(i));
            }
        }
        return builder.toString();
    }
}
