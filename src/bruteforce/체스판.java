package bruteforce;

import java.util.Scanner;

public class 체스판 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine();
        // 1. 체스판을 만든다.

        String[] input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextLine();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int getMin = getMin(i, j, input);
                if (getMin < min) {
                    min = getMin;
                }
            }
        }

        System.out.println(min);


    }

    private static int getMin(int r, int c, String[] input) {

        String[] origin = {"BWBWBWBW", "WBWBWBWB"};

        int count = 0;

        for (int i = 0; i < 8; i++) {
            int row = i + r;
            for (int j = 0; j < 8; j++) {
                int col = j + c;

                if (input[row].charAt(col) != origin[row % 2].charAt(j)) {
                    count++;
                }
            }
        }

        return Math.min(count, 64 - count);
    }
}
