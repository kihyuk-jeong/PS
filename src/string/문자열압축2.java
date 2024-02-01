package string;

import java.util.Scanner;

public class 문자열압축2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        System.out.println(solve(input));
    }

    public static String solve(String input) {

        // 읽지 않아도 되는 문자열을 추가해준다.
        input += " ";
        int count = 1;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i++) {

            if (input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {

                builder.append(input.charAt(i));

                if (count > 1) {
                    builder.append(count);
                    count = 1;
                }

            }
        }

        return builder.toString();

    }
}
