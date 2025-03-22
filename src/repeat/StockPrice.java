package repeat;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {
    public static void main(String[] args) {

        int[] price = {1, 2, 3, 2, 3};
        int[] answer = solve(price);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] solve(int[] price) {

        int n = price.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 1; i < n; i++) {

            while (!stack.isEmpty() && price[stack.peek()] > price[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = n - index - 1;
        }


        return answer;

    }
}
