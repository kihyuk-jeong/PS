package string;

import java.util.Scanner;

public class 숫자만추출 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        System.out.println(solution(input));
    }

    public static int solution(String input) {

        int repeatCount = input.length();

        int answer = 0;

        for (int i = 0; i < repeatCount; i++) {

            char word = input.charAt(i);

            // 아스키코드 숫자 : 48~57
            if (word >= 48 && word <= 57) {
                answer = answer * 10 + (word - 48);
            }
        }
        return answer;
    }
}
