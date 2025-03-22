package repeat;

import java.util.Arrays;
import java.util.Stack;

public class 스톡 {
    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3};

        int[] answer = solve(prices);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] solve(int[] prices) {

        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            if (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                Integer pop = stack.pop();
                answer[pop] = i - pop;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            answer[pop] = prices.length - 1 - pop;
        }

        return answer;

    }
}
