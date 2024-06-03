package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 필수 과목일 때 순서대로 들었는지
 * 2. 과목을 순회한 이후 큐가 비어있는지 (필수과목을 모두 들었는지)
 */
public class 교육과정설계 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String requiredClass = sc.next();
        String signUpClass = sc.next();

        solve(requiredClass, signUpClass);

    }

    private static void solve(String requiredClass, String signUpClass) {

        Queue<Character> queue = new LinkedList<>();

        String answer = "NO";

        for (Character character : requiredClass.toCharArray()) {
            queue.offer(character);
        }

        for (Character character : signUpClass.toCharArray()) {

            if (queue.contains(character)) {
                if (queue.poll() != character) {
                    break;
                }

                // 필수 과목을 모두 들었다면 큐바 비어있을 것
                if (queue.isEmpty()) {
                    answer = "YES";
                }
            }
        }
        System.out.println(answer);
    }
}
