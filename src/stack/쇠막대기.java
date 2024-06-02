package stack;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        solve(input);
    }

    private static void solve(String input) {

        int answer = 0;

        Stack<String> stack = new Stack<>();
        int length = input.length();

        for (int i = 0; i < length; i++) {

            String current = input.substring(i, i + 1);

            if (current.equals("(")) {
                stack.push(current);
            } else {
                String prev = input.substring(i - 1, i);

                if (prev.equals("(")) {
                    stack.pop();
                    answer += stack.size();
                } else {
                    // prev 값이 ")" 라면
                    stack.pop();
                    answer +=1;
                }
            }


        }

        System.out.println(answer);



    }

}
