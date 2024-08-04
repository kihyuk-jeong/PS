package recursive.dfs;

// ArrayList 로 변형해야함. 2차원 배열은 시간초과
// https://www.acmicpc.net/problem/11725
import java.util.Scanner;

public class 트리의부모찾기 {

    static int n;
    static boolean [] visited;
    static boolean [][] graph;
    static int [] answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];
        answer = new int[n + 1];

        for (int i = 0; i < n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }

    }

    private static void dfs(int idx) {

        visited[idx] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[idx][i]) {
                answer[i] = idx;
                dfs(i);
            }
        }

    }
}
