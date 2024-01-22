package string;

import java.util.Scanner;

public class 변환기2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        System.out.println(solution(input));

    }

    public static String solution(String input) {

        String answer = "";

        for (char word : input.toCharArray()) {

            if (Character.isLowerCase(word)) {
                answer += Character.toUpperCase(word);
            } else {
                answer += Character.toLowerCase(word);
            }
        }
        return answer;
    }

}
