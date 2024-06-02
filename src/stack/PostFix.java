package stack;

import java.util.Scanner;
import java.util.Stack;

public class PostFix {

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

                if (character == '+') {
                    stack.push(lt + rt);
                } else if (character == '-') {
                    stack.push(lt - rt);
                } else if (character == '/') {
                    stack.push(lt / rt);
                } else {
                    stack.push(lt * rt);
                }
            }
        }

        System.out.println(stack.pop());

    }


}
