package news;

import java.util.Scanner;
import java.util.Stack;

public class 스택으_오름차순_수열_만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int num = 1;
        boolean flag = true;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int target = arr[i];
            if (target >= num) {
                while (target >= num) {
                    stack.push(num++);
                    builder.append("+\n");
                }

                stack.pop();
                builder.append("-\n");
            } else {
                int k = stack.peek();
                if (target < k) {
                    flag = false;
                    break;
                } else {
                    stack.pop();
                    builder.append("-\n");
                }
            }
        }

        if (flag) {
            System.out.println(builder);
        }

    }
}
