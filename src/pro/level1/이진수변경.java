package pro.level1;

import java.util.Scanner;
import java.util.Stack;

public class 이진수변경 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        String answer = solve(input);

        System.out.println(answer);
    }

    private static String solve(int input) {

        StringBuilder builder = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        while (input != 0) {
            stack.push(input % 2);
            input /= 2;
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }
}
