package repeat.more;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        Stack<Integer> stack = new Stack<>();

        for (Character part : input.toCharArray()) {

            if (Character.isDigit(part)) {
                stack.push(part - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();

                int result = operation(lt, rt, part);

                stack.push(result);
            }
        }

        System.out.println(stack.pop());
    }

    private static int operation(int lt, int rt, Character part) {

        if (part == '+') {
            return lt + rt;
        }

        if (part == '/') {
            return lt / rt;
        }

        if (part == '*') {
            return lt * rt;
        }

        return lt - rt;

    }
}
