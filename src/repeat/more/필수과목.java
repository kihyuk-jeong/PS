package repeat.more;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 나의 필수 과목을 모두 QUEUE 에 넣는다.
 * 2. 플래닝한 과목을 하나씩 뽑아서, queue 에 없다면 애초에 필수과목이 아니니 알빠가 아님.
 * 3. 만약 queue 에 존재한다면, 뽑아. 근데 다르다면 순서가 잘못된거임.
 */


public class 필수과목 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String required = sc.next();
        String plan = sc.next();

        Queue<Character> queue = new LinkedList<>();


        for (Character requiredSubject : required.toCharArray()) {
            queue.offer(requiredSubject);
        }

        String answer = "NO";

        for (Character planSubject : plan.toCharArray()) {

            if (queue.contains(planSubject)) {

                Character current = queue.poll();

                if (current != planSubject) {
                    break;
                }
            }
        }

        if (queue.isEmpty()) {
            answer = "YES";
        }

        System.out.println(answer);



    }
}
