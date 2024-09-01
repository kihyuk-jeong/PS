import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private static char[] nums = {'a', 'b', 'c'};
    private static List<List<Character>> result = new ArrayList<>();

    public static void main(String[] args) {
        backtrack(0, new ArrayList<>());
        System.out.println(result);
    }

    private static void backtrack(int index, List<Character> current) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 현재 숫자를 포함하지 않는 경우
        backtrack(index + 1, current);

        // 현재 숫자를 포함하는 경우
        current.add(nums[index]);
        backtrack(index + 1, current);

        // 백트래킹: 현재 추가한 숫자를 제거하여 이전 상태로 복원
        current.remove(current.size() - 1);
    }
}
