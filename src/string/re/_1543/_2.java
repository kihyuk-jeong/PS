package string.re._1543;

import java.util.Scanner;

public class _2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String document = sc.nextLine();
        String word = sc.nextLine();

        int documentLength = document.length();
        int wordLength = word.length();

        boolean isMatch = true;
        int count = 0;

        for (int i = 0; i < documentLength; i++) {
            for (int j = 0; j < wordLength; j++) {

                if (i+j >= documentLength || document.charAt(i + j) != word.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                count++;
                i += wordLength-1;
            }

            isMatch = true;

        }

        System.out.println(count);

    }

}
