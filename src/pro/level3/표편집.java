package pro.level3;

import java.util.Arrays;
import java.util.Stack;

public class 표편집 {
    public static void main(String[] args) {

        int n = 8;
        int k = 2;

//        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};

        String answer = solve(n, k, cmd);
        System.out.println(answer);
    }

    private static String solve(int n, int k, String[] cmd) {

        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

//        -1 <- 0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7 <-> 8 <-> 9 -> 10

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        // 가상 공간으로 인해 시작점을 조정해야함
        k += 1;

        Stack<Integer> deleted = new Stack<>();

        for (String value : cmd) {

            if ("C".equals(value)) {
                deleted.push(k);

                up[down[k]] = up[k];
                down[up[k]] = down[k];

                // 삭제 후 바로 아래로 내려가야함. but, 아래가 없다면 바로 위로 이동
                k = n < down[k] ? up[k] : down[k];
            } else if ("Z".equals(value)) {
                Integer restore = deleted.pop();

                up[down[restore]] = restore;
                down[up[restore]] = restore;
            } else {

                String[] split = value.split(" ");
                int x = Integer.parseInt(split[1]);

                for (int i = 0; i < x; i++) {
                    k = split[0].equals("U") ? up[k] : down[k];
                }
            }


        }

        String[] answer = new String[n];
        Arrays.fill(answer, "O");

        for (int deletedValue : deleted) {
            answer[deletedValue - 1] = "X";
        }

        return Arrays.toString(answer);
    }
}
