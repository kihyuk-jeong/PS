package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 모든아나그램찾기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        String input = sc.next();

        solve(word, input);

    }

    private static void solve(String word, String input) {

        Map<Character, Integer> answer = new HashMap<>();

        Map<Character, Integer> inputMap = new HashMap<>();

        for (Character key : input.toCharArray()) {
            inputMap.put(key, inputMap.getOrDefault(key, 0) + 1);
        }

        int wordLength = word.length();
        int inputLength = input.length();

        int count = 0;
        int lt = 0;

        getInitMap(word, inputLength, answer);

        for (int rt = inputLength - 1; rt < wordLength; rt++) {

            answer.put(word.charAt(rt), answer.getOrDefault(word.charAt(rt), 0) + 1);

//            boolean isValid = validation(answer, inputMap);

            if (answer.equals(inputMap)) {
                count++;
            }

            char removeKey = word.charAt(lt);
            answer.put(removeKey, answer.get(removeKey) - 1);

            if (answer.get(removeKey) == 0) {
                answer.remove(removeKey);
            }

            lt++;

        }

        System.out.println(count);

    }

//    private static boolean validation(Map<Character, Integer> map, Map<Character, Integer> inputMap) {
//
//
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            Character key = entry.getKey();
//            Integer value = entry.getValue();
//
//            if (!inputMap.containsKey(key) || inputMap.get(key) != value) {
//                return false;
//            }
//
//        }
//        return true;
//    }

    private static void getInitMap(String word, int inputLength, Map<Character, Integer> answer) {
        for (int i = 0; i < inputLength - 1; i++) {
            char value = word.charAt(i);
            answer.put(value, answer.getOrDefault(value, 0) + 1);
        }
    }
}
