package pro.level1;

import java.util.Stack;

public class 크레인 {
    public static void main(String[] args) {

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int answer = solve(board, moves);

        System.out.println(answer);
    }

    private static int solve(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();

        int count = 0;

        for (int k : moves) {
            int move = k - 1;

            for (int j = 0; j < board.length; j++) {
                int current = board[j][move];

                if (current != -1 && current != 0) {
                    if (!stack.isEmpty() && stack.peek().equals(current)) {
                        count++;
                        stack.pop();
                    } else {
                        stack.push(current);
                    }

                    board[j][move] = -1;
                    break;
                }
            }

        }

        return count * 2;

    }
}
