package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 스테이지 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int stageCount = sc.nextInt();
        int peopleCount = sc.nextInt();
        int[] stages = new int[peopleCount];

        for (int i = 0; i < peopleCount; i++) {
            stages[i] = sc.nextInt();
        }

        int[] result = solution(stageCount, stages);

        System.out.println(Arrays.toString(result));

    }

    private static int[] solution(int stageCount, int[] stages) {

        Map<Integer, Double> failRateMap = new HashMap<>();

        // 각 스테이지 별 도전자 수
        int[] stagePeoples = new int[stageCount + 2];
        for (int stage : stages) {
            stagePeoples[stage]++;
        }

        // 현재 도전하고 있는 사람 수
        int challengers = stages.length;


        for (int i = 1; i <= stageCount; i++) {

            if (stagePeoples[i] == 0) {
                failRateMap.put(i, 0.);
                continue;
            }

            // i 번째 스테이지에는 N 명의 사람이 존재함
            int n = stagePeoples[i];

            double failRate = (double) n / challengers;
            failRateMap.put(i, failRate);

            challengers -= n;
        }

        return failRateMap.entrySet()
                .stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();


    }
}
