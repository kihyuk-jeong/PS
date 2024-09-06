package repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CalfSearch {

    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    static int[] dir = {-1, 1, 5};
    static int answer;
    static int n, e;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        e = sc.nextInt();

        visited = new boolean[10006];

        queue.offer(n);

        int L = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer current = queue.poll();

                if (current == e) {
                    System.out.println(L);
                    return;
                }

                for (int j = 0; j < 3; j++) {

                    Integer next = current + dir[j];

                    if (next > 0 && next <= 10000 && !visited[next]) {
                        queue.offer(next);
                    }


                }

            }
            L++;

        }
    }

}
