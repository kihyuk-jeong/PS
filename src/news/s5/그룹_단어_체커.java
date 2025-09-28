package news.s5;

import java.util.Scanner;

public class 그룹_단어_체커 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            int[] alpha = new int[26];

            String word = sc.next();

            char[] wordCharArray = word.toCharArray();

            char beforeWord = wordCharArray[0];

            alpha[beforeWord - 'a']++;

            for (int j = 1; j < wordCharArray.length; j++) {

                char newWord = wordCharArray[j];

                if (beforeWord != newWord && alpha[newWord - 'a'] != 0) {
                    flag = false;
                    break;
                }
                alpha[newWord - 'a']++;
                beforeWord = newWord;
            }

            if (flag) {
                count++;
            }
        }

        System.out.println(count);
    }
}
