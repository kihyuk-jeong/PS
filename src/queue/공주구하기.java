package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int prince = sc.nextInt();
        int pick = sc.nextInt();

        solve(prince, pick);
    }

    private static void solve(int prince, int pick) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= prince; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {

            int cycle = pick - 1;

            while (cycle-- > 0) {
                Integer pollValue = queue.poll();
                queue.offer(pollValue);
            }
            queue.poll();
        }

        System.out.println(queue.peek());


    }
}
