package bruteforce;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11005
 */
public class 진법변환_11005_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();

        String answer = "";

        while (N > 0) {

            int value = N % B;
            if (value < 10) {
                answer += value;
            } else {
                answer += (char) ('A' + value - 10);
            }

            N /= B;
        }

        for (int i = answer.length() - 1; i >= 0; i--) {
            System.out.print(answer.charAt(i));
        }
    }
}
