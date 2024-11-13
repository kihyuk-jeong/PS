package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 3일 안에 강연을 해야 한다는 의미는 1일째, 2일째, 3일째 되는날 중 하루는 꼭 강연을 해야 한다는 의미
 * 만약 2일째 되는 날이라면 1일 안에 강연을 해야 하는 기업의 강의는 할 수가 없음
 */

class Lecture implements Comparable<Lecture> {

    int money;
    int time;

    public Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture lecture) {

        return lecture.time - this.time;
    }
}

public class 최대수입 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Lecture> list = new ArrayList<>();
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            int money = sc.nextInt();
            int time = sc.nextInt();

            list.add(new Lecture(money, time));
            maxTime = Math.max(maxTime, time);
        }
        Collections.sort(list);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int j = 0;
        for (int i = maxTime; i >= list.get(list.size()-1).time; i--) {
            for (; j < n; j++) {
                if (list.get(j).time < i) {
                    break;
                }
                queue.offer(list.get(j).money);
            }
            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }
        System.out.println(answer);
    }
}
