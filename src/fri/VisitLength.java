package fri;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class VisitLength {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        int answer = solve(input);

        System.out.println(answer);
    }

    private static int solve(String input) {

        Set<String> answer = new HashSet<>();

        Map<Character, int[]> point = init();

        int x = 5;
        int y = 5;

        for (char value : input.toCharArray()) {

            int[] map = point.get(value);

            int nx = x + map[0];
            int ny = y + map[1];

            if (isValid(nx, ny)) {
                answer.add(x + "_" + y + "_" + nx + "_" + ny);
                answer.add(nx + "_" + ny + "_" + x + "_" + y);

                x = nx;
                y = ny;
            }
        }

        return answer.size() / 2;
    }

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < 11 && 0 <= y && y < 11;
    }

    private static Map<Character, int[]> init() {

        Map<Character, int[]> map = new HashMap<>();

        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('R', new int[]{1, 0});
        map.put('L', new int[]{-1, 0});

        return map;
    }
}
