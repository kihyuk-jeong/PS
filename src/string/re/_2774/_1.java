package string.re._2774;

import java.util.Scanner;

public class _1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char [] text = sc.next().toCharArray();

        int length = text.length;

        for (int i = 0; i < length; i++) {
            if (text[i] >= 65 && text[i] <= 90) {
                int dist = text[i] - 'A';
                text[i] = (char) ('a' + dist);
            } else {
                int dist = text[i] - 'a';
                text[i] = (char) ('A' + dist);
            }
        }

        System.out.println(text);



    }

}
