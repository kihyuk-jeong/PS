package twopointer;

import java.util.Scanner;

/**
 * 1. 연속된 '1' 의 갯수는 (rt-lt) + 1 로 계산
 * 2. 만약 rt 가 위치한 곳이 0이면 1로 변경 후 변경 가능 count 차감
 * 3. 변경 가능 count 가 부족한 경우 Lt 를 0인 곳 까지 이동시키고, 변경 가능 count 1 증가
 * 4. LT 1칸  이동시키고, 연속된 '1' 의 갯수를 다시 갱신
 */
public class 최대길이연속부분수열 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(array, n, k);

    }

    private static void solve(int[] array, int n, int k) {

        int answer = 0;

        int changeCount = 0;

        int lt = 0;
        int rt = 0;

        while (rt < n) {

            if (array[rt] != 1) {
                if (changeCount < k) {
                    changeCount++;
                } else {
                    while (array[lt] != 0) {
                        lt++;
                    }
                    lt++;
                }
            }
            answer = Math.max(answer, (rt - lt) + 1);
            rt++;

        }

        System.out.println(answer);
    }
}
