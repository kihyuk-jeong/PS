package string;

import java.util.Scanner;

public class 가장긴단어2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int maxLength = Integer.MIN_VALUE, position;


        String answer = "";

        while ((position = input.indexOf(' ')) != -1) {

            String temp = input.substring(0, position);
            if (maxLength < temp.length()) {
                maxLength = temp.length();
                answer = temp;
            }

            input = input.substring(position + 1);
        }

        if (input.length() > maxLength) {
            answer = input;
        }

        System.out.println(answer);
    }
}
