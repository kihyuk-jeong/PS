package repeat.more;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LG그램 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] arr1 = sc.next().toCharArray();
        char[] arr2 = sc.next().toCharArray();


        boolean isAnagram = solve(arr1, arr2);

        System.out.println(isAnagram ? "YES" : "NO");

    }

    private static boolean solve(char[] arr1, char[] arr2) {

        Map<Character, Integer> map = new HashMap<>();
        int length = arr1.length;

        for (char c : arr1) {
            map.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i < length; i++) {

            char key = arr2[i];
            if (map.get(key) == null) {
                return false;
            }
            map.computeIfPresent(key, (k, v) -> --v);
        }

        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
