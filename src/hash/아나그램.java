package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input1 = sc.next();
        String input2 = sc.next();

        boolean isAnagram = solve(input1, input2);

        System.out.println(isAnagram ? "YES" : "NO");

    }

    private static boolean solve(String input1, String input2) {

        Map<Character, Integer> map = new HashMap<>();

        boolean isAnagram = true;

        int length1 = input1.length();
        int length2 = input2.length();

        for (int i = 0; i < length1; i++) {

            Integer value = map.putIfAbsent(input1.charAt(i), 1);

            if (value != null) {
                map.put(input1.charAt(i), ++value);
            }
        }


        for (int i = 0; i < length2; i++) {
            char key = input2.charAt(i);
            Integer value = map.get(key);

            if (value == null) {
                isAnagram = false;
                break;
            }
            map.put(key, --value);
        }

        for (Integer value : map.values()) {
            if (value != 0) {
                isAnagram = false;
                break;
            }
        }

        return isAnagram;

    }
}
