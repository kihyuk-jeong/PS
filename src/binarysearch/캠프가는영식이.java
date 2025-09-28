package binarysearch;

import java.util.Scanner;

public class 캠프가는영식이 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        int arrival = sc.nextInt();

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < tc; i++) {

            int busStart = sc.nextInt();
            int interval = sc.nextInt();
            int busCount = sc.nextInt();

            // 얘를 갱신할 때 TC 가 3개인 경우, 첫 번째 TC 에서 -1 이 나오면 그 다음 TC 는 탑승이 가능해도 답이 -1 로 처리될 수 있음.
            int waitTime = solve(arrival, busStart, interval, busCount);
            if (waitTime != -1) {
                answer = Math.min(answer, waitTime);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }


    }

    private static int solve(int arrival, int busStart, int interval, int busCount) {

        int[] busIntervals = new int[busCount];

        for (int i = 0; i < busCount; i++) {
            busIntervals[i] = busStart + (interval * i);
        }

        if (busIntervals[0] >= arrival) {
            return busIntervals[0] - arrival;
        }

        if (busIntervals[busCount - 1] < arrival) {
            return -1;
        }


        int lt = 0;
        int rt = busCount - 1;
        int min = Integer.MAX_VALUE;

        while (lt <= rt) {

            int midIndex = (lt + rt) / 2;
            int mid = busIntervals[midIndex];

            if (arrival <= mid) {
                min = Math.min(min, mid - arrival);

                rt = midIndex - 1;
            } else {
                lt = midIndex + 1;
            }
        }
        return min;
    }
}
