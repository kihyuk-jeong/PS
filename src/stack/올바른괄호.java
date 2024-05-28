package stack;

import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        solve(input);
    }

    private static void solve(String input) {

        boolean isTrue = true;

        Stack<String> stack = new Stack<>();

        for (Character character : input.toCharArray()) {

            if (character == 40) {
                stack.push("(");
            } else {

                if (stack.isEmpty()) {
                    isTrue = false;
                    break;
                }

                stack.pop();
            }
        }


        if (stack.isEmpty() && isTrue) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
