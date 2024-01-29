package string;

import java.util.Scanner;

public class 회문문자열2 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        String answer = solution(input);
        System.out.println(answer);
    }

    public static String solution(String input) {

        String temp = new StringBuilder(input).reverse().toString();

        if(input.equalsIgnoreCase(temp)) {
            return "YES";
        }

        return "NO";
    }
}
