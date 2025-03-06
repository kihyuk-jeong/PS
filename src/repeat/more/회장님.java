package repeat.more;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 회장님 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();   // 문자열 길이 (필요에 따라 활용)
        String input = scanner.next();

        Map<Character, Integer> frequency = new HashMap<>();
        // 문자열의 각 문자를 순회하면서 빈도수 계산
        for (char c : input.toCharArray()) {
            frequency.merge(c, 1, Integer::sum);
        }

        char mostFrequent = ' ';
        int maxCount = 0;
        // 빈도수가 가장 높은 문자 찾기
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequent = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        System.out.println(mostFrequent);
    }
}
