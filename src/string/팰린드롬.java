package string;

import java.util.Scanner;

public class 팰린드롬 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String answer = solution(input);

        System.out.println(answer);
    }

    public static String solution(String input) {

        int length = input.length();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char word = input.charAt(i);
            if (Character.isAlphabetic(word)) {
                builder.append(word);
            }
        }

        String onlyAlphabetWords = builder.toString();
        String onlyAlphabetWordsReverse = builder.reverse().toString();

        return onlyAlphabetWords.equalsIgnoreCase(onlyAlphabetWordsReverse) ? "YES" : "NO";
    }

}
