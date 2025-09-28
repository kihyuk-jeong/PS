package news;

import java.util.Arrays;
import java.util.Scanner;

public class 주몽오더 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(arr);

        int lt = 0;
        int rt = n - 1;
        int count = 0;

        while (lt < rt) {
            int sum = arr[lt] + arr[rt];

            if (sum == m) {
                count++;
                lt++;
                rt--;

            } else if (sum < m) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(count);


    }
}
