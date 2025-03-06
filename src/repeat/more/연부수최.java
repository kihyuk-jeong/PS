package repeat.more;

import java.util.Scanner;

/**
 * 0을 1로 M 번 바꿀 수 있음.
 * 1로 이루어진 연속 부분수열 최대 길이 구하기
 */

public class 연부수최 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // (rt - lt) + 1 이 최대 길이임.
        // changeCount 가 M 까지 찬 상태면 lt 를 0 인 곳 까지 끌어올려야함.
        int lt = 0;
        int max = Integer.MIN_VALUE;
        int changeCount = 0;

        for (int rt = 0; rt < n; rt++) {

            int value = arr[rt];

            if (value == 0) {
                changeCount++;
            }

            if (changeCount > m) {

                while (arr[lt] != 0) {
                    lt++;
                }
                lt++;
                changeCount--;
            }

            max = Math.max(max, (rt - lt) + 1);
        }

        System.out.println(max);


    }
}
