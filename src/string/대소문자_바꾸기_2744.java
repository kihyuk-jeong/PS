package string;

import java.util.Scanner;

/**
 * A : 65, Z : 90
 * 입력 받은 문자열의 범위가 65~90 사이라면 대문자이다. 즉, 입력받은 문자열의 아스키코드 int 값 에서 'A' 값을 뺀다면, 'A' 로부터의 거리가 나온다.
 * 나온 거리를 'a' 에 더하면 입력받은 문자열의 소문자를 출력할 수 있다.
 */

public class 대소문자_바꾸기_2744 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char[] inputArr = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {

            char word = input.charAt(i);

            if ('A' <= word && 'Z' >= word) {
                int dist = word - 'A';
                inputArr[i] = (char) ('a' + dist);
            } else {
                int dist = word - 'a';
                inputArr[i] = (char) ('A' + dist);
            }
        }

        System.out.println(inputArr);

    }
}
