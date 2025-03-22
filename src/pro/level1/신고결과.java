package pro.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 신고결과 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;


        List<Integer> answer = solve(id_list, report, k);

        System.out.println(answer);
    }

    private static List<Integer> solve(String[] idList, String[] report, int k) {

        Map<String, Set<String>> reportMap = new HashMap<>();

        // init
        for (String s : idList) {
            reportMap.put(s, new HashSet<>());
        }

        Map<String, Integer> reportCountMap = new HashMap<>();

        for (String rp : report) {
            String[] split = rp.split(" ");

            String attacker = split[0];
            String victim = split[1];

            Set<String> victims = reportMap.get(attacker);
            victims.add(victim);
        }

        for (String id : idList) {

            Set<String> victims = reportMap.get(id);

            if (!victims.isEmpty()) {
                for (String victim : victims) {
                    reportCountMap.put(victim, reportCountMap.getOrDefault(victim, 0) + 1);
                }
            }
        }


        // K 번 이상 신고당한 리스트
        List<String> target = reportCountMap.entrySet()
                .stream()
                .filter(t -> t.getValue() >= k)
                .map(Map.Entry::getKey)
                .toList();

        // reportMap 의 value 에서 target 이 포함되어있는 KEY 의 count 를 올리면 됨.

        List<Integer> answer = new ArrayList<>();

        for (String id : idList) {

            Set<String> victims = reportMap.get(id);

            int count = target.stream()
                    .filter(victims::contains)
                    .toList()
                    .size();

            answer.add(count);

        }
        return answer;
    }
}
