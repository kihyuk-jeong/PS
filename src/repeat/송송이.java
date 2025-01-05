package repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송송이 {

    private static boolean[] visited;
    private static int[] dir = {-1, 1, 5};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[10001];

        int answer = bfs(n, m);

        System.out.println(answer);


    }

    private static int bfs(int s, int target) {

        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);

        int count = 0;

        while (!queue.isEmpty()) {

            int repeatSize = queue.size();

            for (int i = 0; i < repeatSize; i++) {
                Integer current = queue.poll();

                for (int j = 0; j < 3; j++) {
                    Integer next = current + dir[j];

                    if (next == target) {
                        return count + 1;
                    }


                    if (next > 0 && next < 10001 && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }

            }
            count++;

        }
        return count;
    }


}
