package pro.level1;

import java.util.LinkedList;
import java.util.Queue;

public class 카드뭉치 {
    public static void main(String[] args) {

//        String[] card1 = {"i", "drink", "water"};
//        String[] card2 = {"want", "to"};
//        String[] goal = {"i", "want", "to", "drink", "water"};

        String[] card1 = {"i", "water", "drink"};
        String[] card2 = {"want", "to"};

        String[] goal = {"i", "want", "to", "drink", "water"};

        String result = solve(card1, card2, goal);

        System.out.println(result);

    }

    private static String solve(String[] card1, String[] card2, String[] goal) {

        Queue<String> card1Queue = new LinkedList<>();
        Queue<String> card2Queue = new LinkedList<>();
        Queue<String> goalQueue = new LinkedList<>();

        for (String card : card1) {
            card1Queue.offer(card);
        }

        for (String card : card2) {
            card2Queue.offer(card);
        }

        for (String word : goal) {
            goalQueue.offer(word);
        }


        for (int i = 0; i < goal.length; i++) {
            if (!card1Queue.isEmpty() && card1Queue.peek().equals(goalQueue.peek())) {
                goalQueue.poll();
                card1Queue.poll();
            }

            if (!card2Queue.isEmpty() && card2Queue.peek().equals(goalQueue.peek())) {
                goalQueue.poll();
                card2Queue.poll();
            }
        }
        return goalQueue.isEmpty() ? "YES" : "NO";
    }
}