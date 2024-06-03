package repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavePrincess {

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

        int answer = 0;

        while (!queue.isEmpty()) {

            for (int i = 1; i < pick; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();

            if (queue.size() == 1) {
                answer = queue.poll();
            }

        }

        System.out.println(answer);

    }
}
