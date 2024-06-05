package repeat;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class GetDoll {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();
        int[] moves = new int[k];

        for (int i = 0; i < k; i++) {
            moves[i] = sc.nextInt();
        }

        solve(board, n, moves, k);

    }

    private static void solve(int[][] board, int n, int[] moves, int k) {

        Stack<Integer> stack = new Stack<>();

        int count = 0;

        for (int move : moves) {

            for (int i = 0; i < n; i++) {

                int value = board[i][move-1];

                if (value != 0) {
                    board[i][move-1] = 0;
                    if (!stack.isEmpty() && stack.peek() == value) {
                        stack.pop();
                        count += 2;
                    } else {
                        stack.push(value);
                    }
                    break;
                }
            }


        }

        System.out.println(count);

    }
}
