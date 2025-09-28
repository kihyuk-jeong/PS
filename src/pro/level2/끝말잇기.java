package pro.level2;

import java.util.Arrays;
import java.util.HashSet;

public class 끝말잇기 {

    public static void main(String[] args) {

        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int[] answer = solution(n, words);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int n, String[] words) {

        HashSet<String> usedWords = new HashSet<>();
        char pre = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {

            if (usedWords.contains(words[i]) || pre != words[i].charAt(0)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            usedWords.add(words[i]);
            pre = words[i].charAt(words[i].length() - 1);
            System.out.println(pre);
        }


        return null;


    }
}
