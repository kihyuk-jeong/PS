package string;

import java.util.Scanner;

public class 문서검색_1543 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String document = sc.nextLine();
        String word = sc.nextLine();

        boolean isMatch = true;
        int resultCount = 0;

        // aaaaa

        for (int i = 0; i < document.length(); i++) {
            for (int j = 0; j < word.length(); j++) {

                if (i + j >= document.length() || document.charAt(i + j) != word.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                resultCount++;
                i += word.length() - 1;
            }

            isMatch = true;
        }
        System.out.println(resultCount);
    }
}
