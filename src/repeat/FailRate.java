package repeat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FailRate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int stageCount = sc.nextInt();
        int challengerCount = sc.nextInt();

        int[] stage = new int[challengerCount];

        for (int i = 0; i < challengerCount; i++) {
            stage[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(stage));

        int[] result = solve(stage, stageCount, challengerCount);


    }

    private static int[] solve(int[] stage, int stageCount, int challengerCount) {

        int[] challengers = new int[stageCount + 2];

        for (int i = 0; i < challengerCount; i++) {
            // 각 스테이지에 몇명이 있는지 첼린저스 배열에 저장
            challengers[stage[i]] += 1;
        }

        System.out.println(Arrays.toString(challengers));

        // 실패율 = 현재 스테이지에 도달했으나, 실패한 아이들 / 스테이지에 도달한 아이들
        // 챌린저스[i] 에는 현재 스테이지에 도달해있는 녀셕들이 있고, challengerCount 는 전체 도전 인원이 있음.
        //{1=0.125, 2=0.42857142857142855, 3=0.5, 4=0.5, 5=0.0}
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 1; i <= stageCount; i++) {

            int value = challengers[i];
            double failRate = (double) value / challengerCount;
            map.put(i, failRate);

            challengerCount -= value;
        }


        System.out.println(map);

        return null;


    }
}
