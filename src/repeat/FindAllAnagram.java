package repeat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindAllAnagram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String target = sc.nextLine();

        solve(input, target);

    }

    private static void solve(String input, String target) {

        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> answerMap = new HashMap<>();

        // target 맵 셋팅
        setTargetMap(target, targetMap);
        int targetLength = target.length();
        initAnswerMap(input, targetLength, answerMap);

        // 카운팅
        int lt = 0;
        int count = 0;

        int inputLength = input.length();

        for (int i = targetLength - 1; i < inputLength; i++) {
            Character inputValue = input.charAt(i);
            answerMap.put(inputValue, answerMap.getOrDefault(inputValue, 0) + 1);

            if (answerMap.equals(targetMap)) {
                count++;
            }

            char removeKey = input.charAt(lt);
            answerMap.put(removeKey, answerMap.get(removeKey) - 1);

            if (answerMap.get(removeKey) == 0) {
                answerMap.remove(removeKey);
            }

            lt++;
        }

        System.out.println(count);

    }

    private static void initAnswerMap(String input, int targetLength, Map<Character, Integer> answerMap) {
        for (int i = 0; i < targetLength - 1; i++) {
            Character inputValue = input.charAt(i);
            answerMap.put(inputValue, answerMap.getOrDefault(inputValue, 0) + 1);
        }
    }

    private static void setTargetMap(String target, Map<Character, Integer> targetMap) {
        for (Character targetChar : target.toCharArray()) {
            targetMap.put(targetChar, targetMap.getOrDefault(targetChar, 0) + 1);
        }
    }
}
