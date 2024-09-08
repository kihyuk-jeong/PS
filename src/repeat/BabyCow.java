package repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BabyCow {

    static int[] move = {-1, 1, 5};
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        int answer = findCowPosition(s, e);

        System.out.println(answer);

    }

    private static int findCowPosition(int s, int e) {

        int count = 0;

        queue.offer(s);

        while (!queue.isEmpty()) {

            int repeatCount = queue.size();

            for (int i = 0; i < repeatCount; i++) {

                int current = queue.poll();

                for (int j = 0; j < 3; j++) {

                    int next = current + move[j];

                    if (next == e) {
                        return count+1;
                    }

                    if (next <= 10000 && next > 0) {
                        queue.offer(next);
                    }
                }
            }

            count++;
        }

        return count;
    }


}
