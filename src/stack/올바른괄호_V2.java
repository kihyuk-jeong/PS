package stack;

import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호_V2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // input : (A(BC)D)EF(G(H)(IJ)K)LM(N)

        String input = sc.next();

        solve(input);

    }

    private static void solve(String input) {

        String answer = "";

        Stack<Character> stack = new Stack<>();

        for (Character character : input.toCharArray()) {

            if (character == ')') {
                while (stack.pop() != '(') {
                }
            } else {
                stack.push(character);
            }
        }

        for (Character character : stack) {
            answer += character;
        }

        System.out.println(answer);
    }
}
