package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 슬라이딩 윈도우 + 투포인터 + 해시
 */

public class 매출액의종류 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        ArrayList<Integer> answer = solve(n, k, array);

        for (Integer count : answer) {
            System.out.print(count + " ");
        }

    }

    private static ArrayList<Integer> solve(int n, int k, int[] array) {

        ArrayList<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int lt = 0;

        // k-1 만큼 미리 넣어서 슬라이딩 윈도우 준비
        for (int i = 0; i < k - 1; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        for (int i = k - 1; i < n; i++) {
            Integer key = array[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
            answer.add(map.size());

            map.put(array[lt], map.get(array[lt]) - 1);

            if (map.get(array[lt]) == 0) {
                map.remove(array[lt]);
            }

            lt++;
        }

        return answer;
    }

}