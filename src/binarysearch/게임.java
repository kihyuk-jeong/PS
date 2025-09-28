package binarysearch;

import java.util.Scanner;

public class 게임 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long total = sc.nextLong();
        long win = sc.nextLong();

        int answer = solve(total, win);

        System.out.println(answer);


    }

    private static int solve(long total, long win) {

        long baseWinAmount = (win * 100) / total;

        long lt = 1;
        long rt = 1000000000;
        long answer = 0;
        while (lt <= rt) {

            long mid = (lt + rt) / 2;

            if (isUp(total, win, mid, baseWinAmount)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }

        }
        return answer == 0 ? -1 : (int)answer;
    }

    private static boolean isUp(long total, long win, long mid, long baseWinAmount) {
        long newWinAmount = (win + mid) * 100 / (mid + total);
        return newWinAmount > baseWinAmount;
    }

}
