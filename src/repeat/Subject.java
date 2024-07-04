package repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Subject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String required = sc.nextLine();
        String subject = sc.nextLine();

        solve(required, subject);

    }

    private static void solve(String required, String subject) {

        Queue<Character> queue = new LinkedList<>();

        String answer = "NO";

        for (Character sub : required.toCharArray()) {
            queue.offer(sub);
        }

        for (Character sub : subject.toCharArray()) {

            if (queue.contains(sub)) {
                Character reqSub = queue.poll();

                if (!sub.equals(reqSub)) {
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
