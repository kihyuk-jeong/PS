package repeat.more;

import java.util.Scanner;

public class ReplayNumberV2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int limit = (n / 2) + 1;

        int sum = 0;
        int lt = 1;
        int count = 0;

        for (int rt = 1; rt <= limit; rt++) {
            sum += rt;

            if (sum == n) {
                count++;
            }

            while (sum >= n) {
                sum -= lt;
                lt++;

                if (sum == n) {
                    count++;
                }

            }


        }
        System.out.println(count);

    }
}
