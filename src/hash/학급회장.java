package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학급회장 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String vote = sc.next();

        solve(N, vote);

    }

    private static void solve(int n, String vote) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            char key = vote.charAt(i);

            Integer value = map.computeIfPresent(key, (k, v) -> v + 1);

            if (value == null) {
                map.put(key, 1);
            }
        }

        int max = 0;
        String answer = "";

        for (Character key : map.keySet()) {

            Integer value = map.get(key);
            max = Math.max(max, value);

            if (max == value) {
                answer = key.toString();
            }
        }

        System.out.println(answer);
    }
}
