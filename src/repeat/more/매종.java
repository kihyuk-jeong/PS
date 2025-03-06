package repeat.more;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 매종 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }

        int lt = 0;
        for (int i = k-1; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            answer.add(map.size());

            map.put(arr[lt], map.get(arr[lt]) - 1);

            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
        }

        for (Integer value : answer) {
            System.out.print(value + " ");
        }

    }
}
