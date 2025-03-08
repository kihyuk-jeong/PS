package pro.level2;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class 짝지어제거하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        Stack<Character> stack = new Stack<>();

        for (char value : input.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(value);
            } else {
                if (stack.peek() == value) {
                    stack.pop();
                } else {
                    stack.push(value);
                }
            }
        }

        System.out.println(stack.empty() ? 1 : 0);

    }
}
