package pro.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 완주실패 {

    public static void main(String[] args) {

        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String answer = solution(participant, completion);

        System.out.println(answer);

    }

    private static String solution(String[] participant, String[] completion) {

        Set<String> participantSet = new HashSet<>(Arrays.asList(participant));
        Set<String> completionSet = new HashSet<>(Arrays.asList(completion));

        for (String value : completionSet) {
            participantSet.remove(value);
        }

        return participantSet.toString();

    }
}
