package repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SellPoint {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        solve(N, K, array);

    }

    private static void solve(int n, int k, int[] array) {

        Map<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> answer = new ArrayList<>();

        // 슬라이딩 윈도우 초기 셋팅
        for (int i = 0; i < k - 1; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        int lt = 0;
        for (int i = k - 1; i < n; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            answer.add(map.keySet().size());

            map.put(array[lt], map.get(array[lt]) - 1);

            if (map.get(array[lt]) == 0) {
                map.remove(array[lt]);
            }

            lt++;
        }

        System.out.println(answer);

    }


}
