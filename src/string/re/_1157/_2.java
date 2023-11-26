package string.re._1157;

import java.util.Scanner;

public class _2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.next().toUpperCase();

        int[] countArray = new int[26];

        for (int i = 0; i < text.length(); i++) {
            char textCharAt = text.charAt(i);
            countArray[textCharAt - 'A']++;
        }

        int maxValue = 0;
        char maxText = '?';

        for (int i = 0; i < 26; i++) {

            if (maxValue < countArray[i]) {
                maxValue = countArray[i];
                maxText = (char) (i + 'A');
            } else if (maxValue == countArray[i]) {
                maxText = '?';
            }
        }

        System.out.println(maxText);

    }
}
