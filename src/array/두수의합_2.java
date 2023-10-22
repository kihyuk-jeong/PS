package array;

import java.util.Scanner;

public class 두수의합_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        int count = 0;

        boolean[] exist = new boolean[1000001];

        for (int i = 0; i < n; i++) {
            exist[arr[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            int target = x - arr[i];
            if (0 <= target && target <= 1000000) {

                if (exist[target]) {
                    count++;
                }
            }
        }

        System.out.println(count / 2);
    }
}
