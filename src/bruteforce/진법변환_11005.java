package bruteforce;

import java.util.Scanner;

public class 진법변환_11005 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();

        int basePower = B;
        int k = 0;
        while ((long) basePower * B <= N) {
            basePower *= B;
            k++;
        }
        System.out.println(k);
        String answer = "";
        while (N > 0) {
            int D = N / basePower;
            N %= basePower;
            basePower /= B;
            if (D < 10) {
                answer += D;
            } else {
                answer += (char) ('A' - 10 + D);
            }
        }

        System.out.print(answer);

    }
}
