package repeat;

import twopointer.공통원소구하기_set;

import java.util.Scanner;
import java.util.Stack;

public class Steal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        solve(input);
    }

    private static void solve(String input) {

        int length = input.length();
        int count = 0;

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < length; i++) {

            String current = input.substring(i, i + 1);

            if ("(".equals(current)) {
                stack.push(current);
            } else {
                String prev = input.substring(i - 1, i);

                if ("(".equals(prev)) {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count += 1;
                }

            }


        }
        System.out.println(count);
    }
}
