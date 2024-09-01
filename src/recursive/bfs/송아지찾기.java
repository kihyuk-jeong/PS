package recursive.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기 {
    static int answer = 0;
    static int s,e;
    static int[] dis = {1, -1, 5};
    static boolean [] visited;
    static Queue<Integer> queue = new LinkedList<>();

    private static int BFS(int s, int e) {

        visited[s] = true;
        queue.offer(s);
        int L = 0;

        while (!queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                int cur = queue.poll();

                if (cur == e) {
                    return L;
                }


                for (int j = 0; j < 3; j++) {
                    int value = cur + dis[j];

                    if (value > 0 && value <= 10000 && !visited[value]) {
                        visited[value] = true;
                        queue.offer(value);
                    }
                }

            }
            L++;

        }

        return L;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        s = sc.nextInt();
        e = sc.nextInt();

        visited = new boolean[10001];

        System.out.println(BFS(s,e));

    }

}



