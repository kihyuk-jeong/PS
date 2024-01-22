package string;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴단어 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] inputArray = input.split(" ");

        int maxLength = inputArray[0].length();
        int maxIndex = 0;

        for (int i = 1; i < inputArray.length; i++) {
            if (maxLength < inputArray[i].length()) {
                maxLength = inputArray[i].length();
                maxIndex = i;
            }
        }

        System.out.println(inputArray[maxIndex]);

    }
}
