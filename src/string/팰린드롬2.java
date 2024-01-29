package string;

import java.util.Scanner;

public class 팰린드롬2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String answer = solution(input);

        System.out.println(answer);
    }

    public static String solution(String input) {

        input = input.toUpperCase().replaceAll("[^A-Z]", "");

        String reverseInput = new StringBuilder(input).reverse().toString();

        return input.equals(reverseInput) ? "YES" : "NO";


    }

}
