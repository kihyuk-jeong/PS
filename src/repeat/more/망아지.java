package repeat.more;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 가장 가까운 말의 거리가 '최대' 가 되도록
 * 가장 가까운 말의 거리를 임의로 구한 후, 각 마굿간의 길이를 구해서 그 값이 C 에 도달하지 못하면 마굿간의 길이를 점점 줄여야함.
 */

public class 망아지 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int lt = arr[0];
        int rt = arr[n - 1];

        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (getCount(mid, arr) < m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        System.out.println(answer);

    }

    private static int getCount(int mid, int[] arr) {

        // 일단 arr[0] 에 말을 배치하고 시작
        int position = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];

            // 최대 거리가 mid 니까.
            if (target - position >= mid) {
                count++;
                position = arr[i];
            }
        }
        return count;
    }

}
