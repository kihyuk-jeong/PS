package array;

import java.util.Scanner;

public class 피보나치수열 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int[] answer = solve(tc);

        for (int number : answer) {
            System.out.print(number + " ");
        }
    }

    public static int[] solve(int tc) {

        int[] answer = new int[tc];

        answer[0] = 1;
        answer[1] = 1;
        answer[2] = 2;


        for (int i = 3; i < tc; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;

    }
}
