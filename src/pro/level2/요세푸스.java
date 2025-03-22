package pro.level2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = solve(n, k);

        System.out.println(answer);
    }

    private static int solve(int n, int k) {

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = n; i >= 1; i--) {
            queue.offer(i);
        }
        System.out.println(queue);

        while (queue.size() > 1) {
            for (int i = 0; i < k-1; i++) {
                Integer poll = queue.poll();
                queue.offer(poll);
            }

            queue.poll();
        }

        return queue.peek();




    }
}
