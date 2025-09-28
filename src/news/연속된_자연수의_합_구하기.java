package news;

import java.util.Scanner;

public class 연속된_자연수의_합_구하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int lt = 1;
        int rt = 1;
        int count = 1;
        int sum = 1;

        while (rt != n) {
            if (sum == n) {
                count++;
                rt++;
                sum += rt;
            } else if (sum > n) {
                sum -= lt;
                lt++;
            } else {
                rt++;
                sum += rt;
            }
        }

        System.out.println(count);

    }
}
