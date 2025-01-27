package repeat.more;

import java.util.Scanner;

public class 연속된자연수의합 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int point = (n/2) + 1;

        int lt = 1;

        int answer = 0;
        int sum = 0;

        for (int rt = 1; rt <= point; rt++) {

            sum += rt;

            if (sum == n) {
                answer++;
            }

            while (sum >= n) {
                sum -=lt;
                lt++;

                if (sum == n) {
                    answer++;
                }

            }


        }

        System.out.println(answer);
    }

}
