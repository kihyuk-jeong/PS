package pro.level2;

import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        boolean answer = solve(input);

        System.out.println(answer);
    }

    private static boolean solve(String input) {

        Stack<Character> stack = new Stack<>();

        for (char value : input.toCharArray()) {

            if (value == '(') {
                stack.push(value);
            } else {

                // stack 이 비어있을 때 pop 을 하면 exception 발생
                if (stack.isEmpty() || stack.pop() == value) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
