package pro.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */

public class 오픈채팅방 {

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};

        String[] result = solve(record);

        System.out.println(Arrays.toString(result));

    }

    private static String[] solve(String[] record) {

        int recordLength = record.length;

        Map<String, String> map = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < recordLength; i++) {
            String[] splitRecord = record[i].split(" ");

            if (splitRecord.length == 3) {
                map.put(splitRecord[1], splitRecord[2]);
            }
        }

        for (String value : record) {
            String[] split = value.split(" ");

            if ("Enter".equals(split[0])) {
                answer.add(map.get(split[1]) + "님이 들어왔습니다.");
            }

            if ("Leave".equals(split[0])) {
                answer.add(map.get(split[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
