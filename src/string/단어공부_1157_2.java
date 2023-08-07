package string;

import java.util.Scanner;

public class 단어공부_1157_2 {

    private static int getAlpCount(String input, char alp) {

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == alp) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int maxValue = -1;
        char result = '?';

        String input = sc.next().toUpperCase();

        for (char alp = 'A'; alp <= 'Z'; alp++) {

            int alpCount = getAlpCount(input, alp);

            if (maxValue < alpCount) {
                maxValue = alpCount;
                result = alp;
            } else if (maxValue == alpCount) {
                result = '?';
            }
        }
        System.out.println(result);
    }
}
