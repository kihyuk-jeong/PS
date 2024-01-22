package string;

import java.util.Scanner;

public class 문자찾기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next().toLowerCase();
        String word = sc.next().toLowerCase();

        System.out.println(solution(input, word));

    }

    public static int solution(String input, String word) {

        int answer = 0;
        char charWord = word.charAt(0);

        int inputLength = input.length();

        for (int i = 0; i < inputLength; i++) {
            if (input.charAt(i) == charWord) {
                answer++;
            }
        }

        return answer;
    }

}
