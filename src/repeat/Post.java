package repeat;

import java.util.Scanner;
import java.util.Stack;

public class Post {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        solve(input);

    }

    private static void solve(String input) {

        Stack<Integer> stack = new Stack<>();

        for (Character character : input.toCharArray()) {

            if (Character.isDigit(character)) {
                stack.push(character - 48);
            } else {

                int rt = stack.pop();
                int lt = stack.pop();

                int result = calculator(character, lt, rt);

                stack.push(result);
            }
        }

        System.out.println(stack.peek());

    }

    private static int calculator(Character character, int lt, int rt) {

        if (character == '+') {
            return lt + rt;
        } else if (character == '-') {
            return lt - rt;
        } else if (character == '/') {
            return lt / rt;
        } else {
            return lt * rt;
        }
    }
}
