package repeat.more;

import java.util.Scanner;

/**
 * 0과 1로 구성되어있는 숫자가 주어짐.  최대 연속 1이 나오는 횟수 구하기.
 * 단, K 번 까지는 0을 1로 바꿀 수 있음.
 */

public class 최대길이연속부분수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = 0;
        int count = 0;
        int answer = 0;

        for (int rt = 0; rt < n; rt++) {

            if (arr[rt] == 0) {
                count++;
            }

            while (count > k) {

                if (arr[lt] == 0) {
                    count--;
                }

                lt++;
            }
            answer = Math.max(answer, (rt - lt) + 1);
        }

        System.out.println(answer);


    }
}
