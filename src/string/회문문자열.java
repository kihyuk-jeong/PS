package string;

import java.util.Scanner;

// Goo ooG
public class 회문문자열 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        String answer = solution(input);
        System.out.println(answer);
    }

    public static String solution(String input) {

        input = input.toLowerCase();

        int repeatCount = input.length() / 2;
        int length = input.length();


        for (int i = 0; i < repeatCount; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return "NO";
            }
        }

        return "YES";
    }

}
