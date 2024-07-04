package repeat;

import java.util.Scanner;
import java.util.Stack;

public class Metal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        solve(input);
    }

    private static void solve(String input) {

        Stack<Character> stack = new Stack<>();

        int length = input.length();

        int answer = 0;

        for (int i = 0; i < length; i++) {

            char current = input.charAt(i);

            if ('(' == current) {
                stack.push(current);
            } else {

                if (input.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }

            }

        }

        System.out.println(answer);

    }
}
