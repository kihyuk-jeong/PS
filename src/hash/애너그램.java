package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 2개의 input 이 모두 같은 길이임이 보장될 때
 */
public class 애너그램 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input1 = sc.next();
        String input2 = sc.next();

        Map<Character, Integer> map = new HashMap<>();

        for (char key : input1.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        String result = solve(map, input2);

        System.out.println(result);

    }

    private static String solve(Map<Character, Integer> map, String input2) {

        String answer = "YES";

        for (char key : input2.toCharArray()) {
            if (!map.containsKey(key) || map.get(key) == 0) {
                return "NO";
            }
            map.put(key, map.get(key) - 1);
        }
        return answer;
    }

}
