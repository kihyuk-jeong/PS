package array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 방문길이 {

    private static final int[] up = {0, 1};
    private static final int[] down = {0, -1};
    private static final int[] left = {-1, 0};
    private static final int[] right = {1, 0};


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        int answer = solution(input);

        System.out.println(answer);
    }

    private static int solution(String dirs) {

        int length = dirs.length();

        Set<String> hashSet = new HashSet<>();

        int x = 5;
        int y = 5;

        for (int i = 0; i < length; i++) {
            int[] location = getMoveLocation(dirs.charAt(i));

            int nextX = x + location[0];
            int nextY = y + location[1];

            // 넘어가면 패스
            if (isOutOfIndex(nextX, nextY)) {
                continue;
            }

            hashSet.add("X" + x + "Y" + y + "nextX" + nextX + "nextY" + nextY);
            hashSet.add("nextX" + nextX + "nextY" + nextY + "X" + x + "Y" + y);

            x = nextX;
            y = nextY;
        }

        return hashSet.size() / 2;
    }

    private static boolean isOutOfIndex(int x, int y) {
        return x > 10 || x < 0 || y > 10 || y < 0;
    }

    private static int[] getMoveLocation(char input) {
        return switch (input) {
            case 'U' -> up;
            case 'D' -> down;
            case 'L' -> left;
            case 'R' -> right;
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };

    }
}
