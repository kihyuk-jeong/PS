package string;

import java.util.Scanner;

public class 가장짧은문자거리2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        char target = sc.next().charAt(0);

        int[] answer = solution(input, target);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(String input, char target) {

        int distance = 1000;
        int length = input.length();

        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {

            char word = input.charAt(i);

            if (word == target) {
                distance = 0;
            } else {
                distance++;
            }
            answer[i] = distance;
        }

        for (int i = length - 1; i >= 0; i--) {
            char word = input.charAt(i);

            if (word == target) {
                distance = 0;
            } else {
                distance++;
                answer[i] = Math.min(answer[i], distance);
            }
        }

        return answer;
    }
}
