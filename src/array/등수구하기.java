package array;

import java.util.Arrays;
import java.util.Scanner;

public class 등수구하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int[] inputArray = new int[tc];

        for (int i = 0; i < tc; i++) {
            inputArray[i] = sc.nextInt();
        }

        solve(inputArray);
    }

    public static void solve(int[] inputArray) {

        int[] answer = new int[inputArray.length];

        for (int i = 0; i < answer.length; i++) {

            int score = 1;

            for (int j = 0; j < answer.length; j++) {
                if (inputArray[i] < inputArray[j]) {
                    score++;
                }
            }
            answer[i] = score;
        }

        for (int rank : answer) {
            System.out.print(rank +" ");
        }

    }
}
