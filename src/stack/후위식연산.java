package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 아스키코드 48 은 숫자 0
 * char 숫자 에서 아라비아 숫자를 구하려면 48을 뺴면 됨.
 */

public class 후위식연산 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        solve(input);
    }

    private static void solve(String input) {

        Stack<Integer> stack = new Stack<>();

        for (Character character : input.toCharArray()) {

            // 숫자라면 stack 에 Push
            if (Character.isDigit(character)) {
                stack.push(character - 48);
            } else {
                Integer rt = stack.pop();
                Integer lt = stack.pop();

                Integer value = calculation(character, lt, rt);
                stack.push(value);

            }
        }

        System.out.println(stack.get(0));

    }

    private static Integer calculation(Character x, Integer lt, Integer rt) {
        if (x == '+') {
            return lt + rt;
        }
        if (x == '*') {
            return lt * rt;
        }
        if (x == '-') {
            return lt - rt;
        }
        return lt / rt;
    }
}