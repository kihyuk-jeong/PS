package array;

import java.util.Arrays;
import java.util.Scanner;

public class 점수계산 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        int[] inputArray = new int[tc];

        for (int i = 0; i < tc; i++) {
            inputArray[i] = sc.nextInt();
        }

        int answer = solve(inputArray);
        System.out.println(answer);
    }

    public static int solve(int[] inputArray) {

        int[] answerArray = new int[inputArray.length];

        int count = inputArray[0] == 1 ? 1 : 0;
        answerArray[0] = inputArray[0] == 1 ? 1 : 0;

        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] == 1 &&  inputArray[i - 1] == 1) {
                count++;
            } else if (inputArray[i] == 1 && inputArray[i - 1] == 0) {
                count = 1;
            } else {
                count = 0;
            }
            answerArray[i] = count;
        }

        return Arrays.stream(answerArray)
                .sum();

    }
}
