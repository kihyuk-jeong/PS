package repeat.more;

import java.util.Scanner;
import java.util.Stack;

public class 파이프 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();

        String input = sc.next();

        int length = input.length();

        int answer = 0;

        for (int i = 0; i < length; i++) {
            char charAt = input.charAt(i);

            if (charAt == '(') {
                stack.push(charAt);
            } else {

                char prev = input.charAt(i - 1);

                if (prev == '(') {
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
