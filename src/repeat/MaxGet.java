package repeat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Times implements Comparable<Times> {

    int money;
    int limit;

    public Times(int money, int limit) {
        this.money = money;
        this.limit = limit;
    }

    @Override
    public int compareTo(Times time) {
        return time.limit - this.limit;
    }
}

public class MaxGet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Times> list = new ArrayList<>();

        int maxLimit = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int limit = sc.nextInt();

            maxLimit = Math.max(maxLimit, limit);

            list.add(new Times(money, limit));
        }

        Collections.sort(list);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;

        for (int i = maxLimit; i >= list.get(list.size() - 1).limit; i--) {

            for (; index < n; index++) {
                Times time = list.get(index);

                if (time.limit == i) {
                    queue.offer(time.money);
                } else {
                    break;
                }
            }

            if (!queue.isEmpty()) {
                answer += queue.poll();
            }

        }

        System.out.println(answer);

    }


}
