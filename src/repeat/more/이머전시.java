package repeat.more;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class EmergencyRoom {
    int order;
    int point;

    public EmergencyRoom(int order, int point) {
        this.order = order;
        this.point = point;
    }
}

public class 이머전시 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<EmergencyRoom> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new EmergencyRoom(i, sc.nextInt()));
        }

        int count = 0;

        while (!queue.isEmpty()) {
            boolean isGet = true;
            EmergencyRoom current = queue.poll();

            for (EmergencyRoom next : queue) {
                if (next.point > current.point) {
                    queue.offer(current);
                    isGet = false;
                    break;
                }
            }

            if (isGet) {
                if (current.order == m) {
                    count++;
                    break;
                } else {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
