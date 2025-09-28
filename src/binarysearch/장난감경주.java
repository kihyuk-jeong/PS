package binarysearch;

// https://www.acmicpc.net/problem/19592

import java.util.Scanner;

public class 장난감경주 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // 참가자 수
            int X = sc.nextInt(); // 트랙 길이
            int Y = sc.nextInt(); // 부스터 최대값

            double[] speeds = new double[N];
            for (int i = 0; i < N; i++) {
                speeds[i] = sc.nextDouble();
            }

            double mySpeed = speeds[N - 1]; // 마지막 참가자(내) 속도

            // 다른 참가자 중 가장 빠른 시간 계산
            double fastestTime = Double.MAX_VALUE;
            for (int i = 0; i < N - 1; i++) {
                double time = X / speeds[i];
                fastestTime = Math.min(fastestTime, time);
            }

            // 내가 부스터 없이 1등이 가능하면 부스터 사용량 0
            double myTimeNormal = X / mySpeed;
            if (myTimeNormal < fastestTime) {
                System.out.println(0);
                continue;
            }

            // 이분탐색으로 최소 부스터 사용량 찾기
            int left = 0;
            int right = Y;
            int answer = -1;

            while (left <= right) {
                int mid = (left + right) / 2; // 부스터 사용량

                // 부스터 사용 시 내 시간 계산
                double remainingDistance = X - mid;
                double myTimeWithBoost;

                if (remainingDistance <= 0) {
                    // 부스터만으로 도착 (1초 소요)
                    myTimeWithBoost = 1;
                } else {
                    // 부스터(1초) + 일반 주행
                    myTimeWithBoost = 1 + (remainingDistance / mySpeed);
                }

                if (myTimeWithBoost < fastestTime) {
                    // 이 부스터 사용량으로 1등이 가능하면 기록하고 더 작은 값 탐색
                    answer = mid;
                    right = mid - 1;
                } else {
                    // 1등이 불가능하면 더 큰 값 탐색
                    left = mid + 1;
                }
            }

            // 최대 부스터를 사용해도 1등이 불가능하면 -1 출력
            System.out.println(answer);
        }

        sc.close();
    }
}