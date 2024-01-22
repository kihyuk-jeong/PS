package string;

import java.util.Scanner;

public class 변환기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        int arrayLength = input.length();


        for (int i = 0; i < arrayLength; i++) {

            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                int dist = input.charAt(i) - 'A';
                System.out.print((char) ('a' + dist));
            } else {
                int dist = input.charAt(i) - 'a';
                System.out.print((char) ('A' + dist));
            }
        }
    }
}
