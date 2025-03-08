package pro.level2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 * 바로 떨어지는 아이들은 1초동안 유지되었다고 봐야함.
 */

public class 주식가격 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int[] answer = solve(arr);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] solve(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        int length = arr.length;

        int[] answer = new int[length];

        for (int i = 1; i < length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int current = stack.pop();
                answer[current] = i - current;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int current = stack.pop();
            answer[current] = length - 1 - current;
        }


        return answer;


    }

}