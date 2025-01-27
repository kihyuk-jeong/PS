package repeat.more;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. N 개의 마굿간 과 C 마리의 말이 존재함.
 * 2. 각 마굿간에 말을 배치 하되, 말과 말 사이의 가장 가까운 거리가 '최대' 가 되는 거리를 출력
 */

public class 말 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] horseHouse = new int[n];

        for (int i = 0; i < n; i++) {
            horseHouse[i] = sc.nextInt();
        }

        int lt = horseHouse[0];
        int rt = horseHouse[horseHouse.length - 1];

        Arrays.sort(horseHouse);

        int answer = Integer.MIN_VALUE;
        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            // 3마리 배치를 못하는 경우 - 길이를 늘려줘야함
            if (getCount(mid, horseHouse) < c) {
                rt = mid - 1;
            } else {
                answer = Math.max(mid, answer);
                lt = mid + 1;
            }
        }

        System.out.println(answer);

    }

    private static int getCount(int minDistance, int [] array) {

        // 1번 자리에 배치하고 시작
        int point = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            int distance = Math.abs(point - array[i]);

            if (distance >= minDistance) {
                count++;
                point = array[i];
            }

        }
        return count;
    }
}
