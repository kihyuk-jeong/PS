package pro.level2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 조합으로 풀 수 있을 거 같은데.. .
 */

public class 메뉴리뉴얼 {

    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2, 3, 5};

//        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2, 3, 4};


        List<String> answer = solve(orders, course);
        Collections.sort(answer);
        System.out.println(answer);
    }

    private static List<String> solve(String[] orders, int[] course) {

        List<String> answer = new ArrayList<>();

        for (int kind : course) {
            Map<String, Integer> map = new HashMap<>();

            for (String order : orders) {

                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                String sortedOrder = new String(arr);

                if (order.length() >= kind) {
                    dfs(0, sortedOrder, map, kind, new ArrayList<>());
                }
            }

            int max = map.values()
                    .stream()
                    .max(Integer::compareTo)
                    .orElse(Integer.MAX_VALUE);

            // VALUE 가 2개 이상인 애들 중에서.. 일단 이거 value 의 size 내림차순으로 정렬 필요할듯
            List<String> words = map.entrySet()
                    .stream()
                    .filter(t -> t.getValue() == max && t.getValue() >= 2)
                    .map(Map.Entry::getKey)
                    .toList();

            answer.addAll(words);

        }


        return answer;
    }

    private static void dfs(int startIndex, String order, Map<String, Integer> map, int kind, List<String> temp) {

        if (temp.size() == kind) {

            StringBuilder tempString = new StringBuilder();

            for (String t : temp) {
                tempString.append(t);
            }
            map.put(tempString.toString(), map.getOrDefault(tempString.toString(), 0) + 1);
            return;
        }

        for (int i = startIndex; i < order.length(); i++) {
            temp.add(order.substring(i, i + 1));
            dfs(i + 1, order, map, kind, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
