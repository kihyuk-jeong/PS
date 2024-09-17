package bruteforce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * N 번째 스테이지에 머물러있는 사용자를 전체 사용자에서 빼면 N+1 이상 에서 머물러 있는 스테이지만 존재하게 된다.
 */

public class 스테이지 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 총 스테이지 수
        int N = sc.nextInt();
        // 도전자
        int M = sc.nextInt();

        int[] stages = new int[M];

        for (int i = 0; i < M; i++) {
            stages[i] = sc.nextInt();
        }

        // 스테이지가 5 라면, 5를 깬 도전자는 6에 위치.
        // 0을 안씀. index 1부터
        int[] challenger = new int[N + 2];

        // 각 스테이지별 머물러있는 도전자 수 저장 배열
        for (int i = 0; i < M; i++) {
            challenger[stages[i]] += 1;
        }

        Map<Integer, Double> failRate = new HashMap<>();

        for (int i = 1; i <= N; i++) {

            int value = challenger[i];

            if (value == 0) {
                failRate.put(i, 0.0);
            } else {
                double v = ((double) value / M);
                failRate.put(i, v);
            }

            M -= value;
        }
        System.out.println(failRate);


        int[] array = failRate.entrySet()
                .stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(HashMap.Entry::getKey)
                .toArray();

        System.out.println(Arrays.toString(array));


    }
}
