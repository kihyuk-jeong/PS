package repeat;

import java.util.Scanner;

public class 토이레이싱 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {

            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int[] v = new int[n];

            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt();
            }

            int answer = solve(n, x, y, v);
            System.out.println(answer);
        }
    }

    private static int solve(int n, int x, int y, int[] v) {

        // 1. 내 시간
        double myTime = (double) x / v[n - 1];


        // 2. 1등 시간
        double victoryUserTime = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double time = ((double) x / v[i]);
            victoryUserTime = Math.min(time, victoryUserTime);
        }

        // 3. 부스터를 쓰지 않아도 1등인가 ?
        if (myTime == victoryUserTime) {
            return 0;
        }

        // 4. 이분탐색으로 최소 부스터 사용량 찾기
        int answer = -1;
        int lt = 0;
        int rt = y;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            double remainingDistance = x - mid;
            double boosterMyTime;

            if (remainingDistance <= 0) {
                boosterMyTime = 1;
            } else {
                boosterMyTime = 1 + (remainingDistance / v[n - 1]);
            }

            if (isVictory(victoryUserTime, boosterMyTime)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    private static boolean isVictory(double victoryUserTime, double boosterMyTime) {
        return victoryUserTime > boosterMyTime;
    }

}
