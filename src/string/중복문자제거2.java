package string;

import java.util.Scanner;

public class 중복문자제거2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int length = input.length();

        for (int i = 0; i < length; i++) {

            char word = input.charAt(i);

            if (i == input.indexOf(word)) {
                System.out.print(word);
            }
        }
    }
}
