package repeat;

import java.util.Scanner;

public class StringCompact {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        System.out.println(solve(input));
    }

    public static String solve(String input) {

        int n = input.length();

        input += "*";

        StringBuilder answer = new StringBuilder();

        int count = 1;

        for (int i = 0; i < n; i++) {

            if (input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {

                answer.append(input.charAt(i));

                if (count != 1) {
                    answer.append(count);
                    count = 1;
                }
            }
        }

        return answer.toString();
    }
}
