package repeat;

import java.util.Scanner;
import java.util.Stack;

public class RemoveBracket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        solve(input);

    }

    private static void solve(String input) {

        Stack<Character> stack = new Stack<>();

        for (Character character : input.toCharArray()) {

            if (character != ')') {
                stack.push(character);
            } else {
                // ')' 를 만났다면  '(' 가 나올 때 까지 계속 팝.
                while(stack.pop() != '(');
            }

        }

        for (Character character : stack) {
            System.out.print(character.toString());
        }

    }
}
