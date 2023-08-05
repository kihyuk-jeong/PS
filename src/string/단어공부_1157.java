package string;

import java.util.Scanner;

public class 단어공부_1157 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next().toUpperCase();

        int maxValue = -1;
        char answer = '?';
        int[] arr = new int[26];

        int length = input.length();

        for (int i = 0; i < length; i++) {
            arr[input.charAt(i) - 'A']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                answer = (char) ('A' + i);
            }

            else if (maxValue == arr[i]) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
