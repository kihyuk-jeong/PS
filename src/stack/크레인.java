package stack;

import java.util.Scanner;
import java.util.Stack;

public class 크레인 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }


        int m = sc.nextInt();
        int[] moves = new int[m];

        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        solve(n, board, m, moves);
    }

    public static void solve(int n, int[][] board, int m, int[] moves) {

        Stack<Integer> bucket = new Stack<>();

        int count = 0;

        for (int move : moves) {
            for (int i = 0; i < n; i++) {
                int value = board[i][move - 1];

                if (value != 0) {
                    board[i][move - 1] = 0;

                    if (!bucket.isEmpty() && value == bucket.peek()) {
                        count++;
                        bucket.pop();
                    } else {
                        bucket.push(value);
                    }

                    break;
                }
            }
        }

        System.out.println(count * 2);
    }
}