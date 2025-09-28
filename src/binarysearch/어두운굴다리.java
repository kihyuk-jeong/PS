package binarysearch;

import java.util.Scanner;

/**
 * 가로등을 설치할 개수 M 개
 * 각 가로등의 위치 X
 * 최소한의 높이로 굴다리 모든 길 0~N 을 밝히고자 함.
 * 가로등의 높이가 H 라면, 왼쪽 오른쪽 모두 H 만큼 주의를 비춤.
 */

public class 어두운굴다리 {

    public static void main(String[] args) {
        /**
         * 입력
         * 첫번쨰 입력 : 굴다리 길이 N
         * 두번째 입력 : 가로등의 개수 M
         * 세번째 입력 : 가로등의 위치 X
         */

        // 높이가 N 이라면, 가로등이 1개이고 어디에 두둔 전부 덮을 수 있음.
        // 즉, rt = N 으로 두어도 되지 않을까 싶음.
        // 높이는 lt = 1로 두어볼까?

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] load = new int[m];

        for (int i = 0; i < m; i++) {
            load[i] = sc.nextInt();
        }

        int answer = solve(n, m, load);

        System.out.println(answer);
    }

    private static int solve(int n, int m, int[] load) {

        int answer = Integer.MAX_VALUE;

        int lt = 1;
        int rt = 5;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (isComplete(n, mid, load)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }

        }
        return answer;
    }

    private static boolean isComplete(int n, int height, int[] load) {

        int m = load.length;

        if (load[0] - height > 0) {
            return false;
        }

        for (int i = 0; i < m - 1; i++) {
            if (load[i + 1] - load[i] > 2 * height) {
                return false;
            }
        }


        if (load[m - 1] + height < n) {
            return false;
        }

        return true;

    }
}
