package repeat.more;

import java.util.Scanner;

public class 연자합 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //연속된 자연수를 구해야 하기 때문에 9는 나올수가 없음.
        // 즉 n/2 + 1 까지만 필요함.
        int n = sc.nextInt();
        int length = (n / 2) + 1;

        int sum = 0;
        int count = 0;
        int lt = 1;

        for (int rt = 1; rt <= length; rt++) {
            sum += rt;

            if (sum == n) {
                count++;
            }

            while (sum >= n) {
                sum -=lt;
                lt++;

                if (sum == n) {
                    count++;
                }
            }

        }

        System.out.println(count);

    }
}
