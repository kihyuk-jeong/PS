package pro.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 괄호회전 {

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
        input += input;

        int answer = 0;

        for (int i = 0; i < length; i++) {
            Stack<String> stack = new Stack<>();
            boolean isContinue = true;

            for (int j = i; j < i + length; j++) {
                String value = input.substring(j, j + 1);

                if (!map.containsKey(value)) {
                    stack.push(value);
                } else {
                    if (stack.isEmpty() || !map.get(value).equals(stack.pop())) {
                        isContinue = false;
                        break;
                    }
                }
            }

            if (isContinue && stack.isEmpty()) {
                answer++;
            }

        }
        return answer;
    }
}
