package string;

import java.util.Scanner;

/**
 * 'a' ~ 'z' ==  97 ~ 122
 * 'A' ~ 'B' == 65 ~ 90
 */

public class 특정문자뒤집기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char[] charArray = input.toCharArray();

        int lt = 0;
        int rt = charArray.length - 1;

        while (lt < rt) {

            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            } else {
                char temp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = temp;

                lt++;
                rt--;
            }
        }

        System.out.println(charArray);


    }
}
