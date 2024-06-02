package repeat;

import java.util.Scanner;
import java.util.Stack;

/**
 * 1.  ( 를 만나면 무조건 푸시
 * 2. ) 를 만났을 때 이전 괄호가 ( 라면 레이저로, pop 해서 레이저를 뺌. 이후 남아있는 '(' 만큼이 잘려져 나간 길이
 * 3.  만약 이전 괄호도 ( 라면
 */

public class 쇠막대기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        solve(input);

    }

    private static void solve(String input) {

        Stack<String> stack = new Stack<>();

        int length = input.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            String current = input.substring(i, i + 1);

            if ("(".equals(current)) {
                stack.push(current);
            } else {
                //")" 라면 ?
                String prev = input.substring(i - 1, i);

                if ("(".equals(prev)) {
                    stack.pop();
                    count += stack.size();
                }  else {
                    stack.pop();
                    count += 1;
                }



            }

        }

        System.out.println(count);

    }


}
