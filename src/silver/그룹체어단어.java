package silver;

import java.util.Scanner;

public class 그룹체어단어 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {

            boolean isChecker = true;

            int [] alpha = new int[26];
            String word = sc.next();

            char beforeWord = word.charAt(0);
            alpha[beforeWord - 'a']++;

            for (int j = 1; j < word.length(); j++) {
                char nextWord = word.charAt(j);
                if (beforeWord != nextWord && alpha[nextWord - 'a'] > 0) {
                    isChecker = false;
                    break;
                }

                alpha[nextWord - 'a']++;
                beforeWord = nextWord;

            }


            if (isChecker) {
                count++;
            }

        }

        System.out.println(count);



    }
}

