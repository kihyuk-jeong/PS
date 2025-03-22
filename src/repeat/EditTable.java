package repeat;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class EditTable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 행의 수
        int n = 8;
        // 시작 행 위치 (0부터 시작)
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};

        String answer = solve(n, k, cmd);

        System.out.println(answer);
    }

    private static String solve(int n, int k, String[] cmd) {

        // 실제 행 개수만큼의 배열 생성 (인덱스: 0 ~ n-1)
        int[] up = new int[n];
        int[] down = new int[n];

        // 각 행에 대해 이전(up)과 다음(down) 행의 인덱스 초기화
        // 첫 행은 이전 행이 없으므로 -1, 마지막 행은 다음 행이 없으므로 -1 사용
        for (int i = 0; i < n; i++) {
            up[i] = (i == 0 ? -1 : i - 1);
            down[i] = (i == n - 1 ? -1 : i + 1);
        }

        System.out.println(Arrays.toString(up));
        System.out.println(Arrays.toString(down));

        // 삭제된 행의 인덱스를 저장할 스택
        Stack<Integer> deleted = new Stack<>();

        // 명령어 처리
        for (String command : cmd) {
            if ("C".equals(command)) {  // 현재 행 삭제
                // 현재 행 k의 다음 행이 있다면, 그 행의 이전(up) 포인터를 현재 행의 이전으로 변경
                if (down[k] != -1) {
                    up[down[k]] = up[k];
                }
                // 현재 행 k의 이전 행이 있다면, 그 행의 다음(down) 포인터를 현재 행의 다음으로 변경
                if (up[k] != -1) {
                    down[up[k]] = down[k];
                }
                // 삭제된 행의 인덱스 저장
                deleted.push(k);

                // 삭제 후 이동: 만약 현재 행의 아래 행이 존재하면 그 행으로, 없으면 위 행으로 이동
                k = (down[k] != -1 ? down[k] : up[k]);

            } else if ("Z".equals(command)) {  // 삭제 복구
                int restoreIndex = deleted.pop();
                // 복구할 행의 이전 행이 존재하면, 그 행의 다음(down)을 복구할 인덱스로 변경
                if (up[restoreIndex] != -1) {
                    down[up[restoreIndex]] = restoreIndex;
                }
                // 복구할 행의 다음 행이 존재하면, 그 행의 이전(up)을 복구할 인덱스로 변경
                if (down[restoreIndex] != -1) {
                    up[down[restoreIndex]] = restoreIndex;
                }
            } else {  // 이동 명령 ("U x" 또는 "D x")
                String[] parts = command.split(" ");
                int moveCount = Integer.parseInt(parts[1]);

                if ("D".equals(parts[0])) {
                    for (int i = 0; i < moveCount; i++) {
                        k = down[k];
                    }
                } else if ("U".equals(parts[0])) {
                    for (int i = 0; i < moveCount; i++) {
                        k = up[k];
                    }
                }
            }
        }

        // 결과 문자열 구성: 모든 행은 기본적으로 'O'
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        // 삭제된 행은 'X'로 표시 (인덱스 그대로 사용)
        while (!deleted.isEmpty()) {
            answer[deleted.pop()] = 'X';
        }
        return new String(answer);
    }
}
