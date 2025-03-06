package repeat.more;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 모그찾 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] base = sc.next().toCharArray();
        char[] target = sc.next().toCharArray();

        Map<Character, Integer> baseMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        int baseLength = base.length;
        int targetLength = target.length;

        // target 셋팅 및 초기 슬라이딩 윈도우 셋팅
        setTargetMap(target, targetMap);
        setInitBaseMap(base, baseMap, targetLength);

        int answer = 0;

        int lt = 0;
        for (int rt = targetLength - 1; rt < baseLength; rt++) {
            char baseKey = base[rt];
            baseMap.put(baseKey, baseMap.getOrDefault(baseKey, 0) + 1);

            if (targetMap.equals(baseMap)) {
                answer++;
            }

            char removeBaseKey = base[lt];
            baseMap.put(removeBaseKey, baseMap.get(removeBaseKey) - 1);

            if (baseMap.get(removeBaseKey) == 0) {
                baseMap.remove(removeBaseKey);
            }
            lt++;
        }

        System.out.println(answer);

    }

    private static void setInitBaseMap(char[] base, Map<Character, Integer> baseMap, int length) {
        for (int i = 0; i < length - 1; i++) {
            char key = base[i];
            baseMap.put(key, baseMap.getOrDefault(key, 0) + 1);
        }
    }

    private static void setTargetMap(char[] target, Map<Character, Integer> targetMap) {
        for (char targetValue : target) {
            targetMap.merge(targetValue, 1, Integer::sum);
        }
    }
}
