package pro.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 괄호회전2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int answer = solve(input);

        System.out.println(answer);
    }

    private static int solve(String input) {

        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");

        int length = input.length();
        int answer = 0;

        String rotateString = input;

        for (int i = 0; i < length; i++) {
            if (isValid(rotateString, map)) {
                answer++;
            }

            rotateString = rotateString.substring(1) + rotateString.charAt(0);
        }

        return answer;
    }

    private static boolean isValid(String rotateString, Map<String, String> map) {

        Stack<String> stack = new Stack<>();
        int n = rotateString.length();

        for (int i = 0; i < n; i++) {
            String value = rotateString.substring(i, i + 1);

            if (!map.containsKey(value)) {
                stack.push(value);
            } else {
                if (stack.isEmpty() || !map.get(value).equals(stack.pop())) {
                    return false;
                }
            }
        }
        return true;
    }
}