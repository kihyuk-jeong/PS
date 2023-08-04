package string;

import java.util.Scanner;

public class 애너그램_1919 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputA = scanner.next();
        String inputB = scanner.next();

        int[] inputAArr = getArrCount(inputA);
        int[] inputBArr = getArrCount(inputB);

        int answer = 0;

        for (int i = 0; i < 26; i++) {
            answer +=  Math.abs(inputAArr[i] - inputBArr[i]);
        }
        System.out.println(answer);
    }

    private static int[] getArrCount(String input) {

        int[] inputArr = new int[26];

        for (int i = 0; i < input.length(); i++) {
            inputArr[input.charAt(i)-'a']++;
        }
        return inputArr;
    }
}
