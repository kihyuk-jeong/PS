package string;

import java.util.Arrays;
import java.util.Scanner;

public class 가장짧은문자거리 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        String target = sc.next();

        int[] answer = solution(word, target.charAt(0));

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(String words, char target) {


        int length = words.length();

        int[] answer = new int[length];

        int distance = 1000;

        for (int i = 0; i < length; i++) {
            if (words.charAt(i) == target) {
                distance = 0;
            } else {
                distance++;
            }
            answer[i] = distance;
        }

        for (int i = length - 1; i >= 0; i--) {
            if (words.charAt(i) == target) {
                distance = 0;
            } else {
                distance++;
            }

            answer[i] = Math.min(answer[i], distance);

        }
        return answer;
    }
}
