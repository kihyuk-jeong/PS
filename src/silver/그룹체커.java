package silver;

import java.util.Scanner;

/**
 * 아스키 코드 활용
 * 알파벳은 총 26개
 * current 알파벳과 prev 알파벳이 다른데 size 가 1 이상이라면 false
 */

public class 그룹체커 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] alphaCount;

        int n = sc.nextInt();
        int count = 0;

        while (n-- > 0) {
            boolean isMatch = true;
            alphaCount = new int[26];
            char[] wordArray = sc.next().toCharArray();

            char prev = wordArray[0];
            alphaCount[prev - 'a']++;

            for (int i = 1; i < wordArray.length; i++) {
                char current = wordArray[i];

                if (prev != current && alphaCount[current - 'a'] > 0) {
                    isMatch = false;
                    break;
                }

                alphaCount[current - 'a']++;
                prev = current;
            }

            if (isMatch) {
                count++;
            }
        }

        System.out.println(count);


    }
}
