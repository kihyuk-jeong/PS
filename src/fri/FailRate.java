package fri;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FailRate {
    public static void main(String[] args) {

        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] solution = solution(n, stages);

        System.out.println(Arrays.toString(solution));

    }

    public static int[] solution(int n, int [] stages) {

        int stageLength = stages.length;

        int[] challengers = new int[n + 2];

        for (int i = 0; i < stageLength; i++) {
            challengers[stages[i]]++;
        }

        Map<Integer, Double> results = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int value = challengers[i];

            if (value == 0) {
                results.put(i, 0.0);
            } else {
                results.put(i, (double) value / stageLength);
            }

            stageLength -= value;
        }

        return results.entrySet().stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
