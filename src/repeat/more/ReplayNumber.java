package repeat.more;

import java.util.Scanner;

public class ReplayNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = 0;
        int sum = 0;
        int count = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];

            if (sum == m) {
                count++;
            }

            while (sum > m) {
                sum -= arr[lt];
                lt++;

                if (sum == m) {
                    count++;
                }

            }

        }

        System.out.println(count);

    }


}
