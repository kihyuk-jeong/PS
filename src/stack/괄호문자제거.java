package stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 1. '(' 가 나오면 스택에 push 하고 계속 진행.
 * 2. '(' 가 아니라면 스택이 비어있나 확인하고, 비어있다면 answer 에 다음 괄호 '(' 가 나올떄 까지 출력
 * 3. 만약 알파벳이 아닌데, 스택이 비어있지 않다면 ')' 가 나올떄까지 스킵하다가 ')' 가 나오면 pop 함.
 * 2. 그러다가 ')' 가 나오면 pop 을 함.
 * 3.
 */

public class 괄호문자제거 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // input : (A(BC)D)EF(G(H)(IJ)K)LM(N)

        String input = sc.next();

        solve(input);

    }

    private static void solve(String input) {

        Stack<Character> stack = new Stack<>();

        ArrayList<String> answer = new ArrayList<>();

        for (Character character : input.toCharArray()) {

            if (!Character.isAlphabetic(character)) {

                if (character == '(') {
                    stack.push(character);
                } else {
                    stack.pop();
                }
            }

            else {
                if (stack.isEmpty()) {
                    answer.add(character.toString());
                }
            }

        }

        // answer
        for (String ans : answer) {
            System.out.print(ans);
        }

    }
}
