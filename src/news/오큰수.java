package news;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 수열이 주어진다. 수열의 원소 N 보다 오른쪽에 있으면서, N 보다 큰 수 중 가장 왼쪽에 있는 수 가 오큰수
 */
public class 오큰수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 1; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }


        System.out.println(Arrays.toString(answer));

        // 1. 처음에는 일단 index 를 넣는다.
        // 2. 그 다음부터 Array[index] 와 이제 들어오는 녀석을 비교
        // 3. 결국 더 크면 (오른쪽에 있고, 가장 왼쪽에 있는 것이 보장됨) 오큰수 answer 배열에.





    }
}
