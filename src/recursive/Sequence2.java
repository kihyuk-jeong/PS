package recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sequence2 {

    static int n, m;
    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        recur(0, new ArrayList<>(), new boolean[n + 1]);  // 사용 여부를 체크할 boolean 배열 추가

//        recur(0, 1, new ArrayList<>());

        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    private static void recur(int number, List<String> letter, boolean[] used) {


        if (number == m) {
            result.add(new ArrayList<>(letter));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;  // 이미 사용한 숫자라면 건너뜀
            }

            used[i] = true;  // 숫자를 사용했다고 표시
            letter.add(String.valueOf(i));
            recur(number + 1, letter, used);
            letter.remove(letter.size() - 1);
            used[i] = false;  // 백트래킹: 다음 경우를 위해 다시 사용 가능하도록 함
        }
    }

    private static void recur(int number, int start, List<String> letter) {

        if (number == m) {
            result.add(new ArrayList<>(letter));
            return;
        }

        for (int i = start; i <= n; i++) {

            letter.add(String.valueOf(i));
            recur(number + 1, i + 1, letter);
            letter.remove(letter.size() - 1);
        }

    }

}