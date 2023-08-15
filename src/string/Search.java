package string;

import java.util.Scanner;

public class Search {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String document = scanner.nextLine();
        String word = scanner.nextLine();

        int result = 0;
        boolean isMatch = true;

        for (int i = 0; i < document.length(); i++) {
            for (int j = 0; j < word.length(); j++) {

                if (i + j >= document.length() || document.charAt(i + j) != word.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                i = word.length() - 1;
                result++;
            }

            isMatch = true;
        }
        System.out.println(result);
    }
}
