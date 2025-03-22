package pro.level2;

import java.util.HashMap;
import java.util.Map;

public class 가격비교 {
    public static void main(String[] args) {

//        String[] want = {"banana", "apple", "rice", "pork", "pot"};
//        int[] number = {3, 2, 2, 2, 1};
//        String[] discount = {"chicken", "apple", "apple", "banana", "rice",
//                "apple", "pork", "banana", "pork", "rice", "pot",
//                "banana", "apple", "banana"};

        String[] want = {"apple"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana", "banana",
                "banana", "banana", "banana", "banana", "banana"};


        int answer = solution(want, number, discount);

        System.out.println(answer);

    }

    private static int solution(String[] want, int[] number, String[] discount) {

        int initLength = want.length;
        int discountLength = discount.length;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < initLength; i++) {
            map.put(want[i], number[i]);
        }

        int count = 0;

        for (int i = 0; i < discountLength - 9; i++) {

            Map<String, Integer> compareMap = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                String key = discount[j];
                compareMap.put(key, compareMap.getOrDefault(key, 0) + 1);
            }

            if (map.equals(compareMap)) {
                count++;
            }

        }

        return count;
    }
}
