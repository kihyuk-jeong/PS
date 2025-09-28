package pro.level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 킨드레드 {

    private static int[] info;
    private static List<Integer>[] graph;
    private static int maxSheep = 0;
    private static int totalSheep = 0;
    private static Set<Integer> nextNodes;

    public static void main(String[] args) {

        info = new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};

        graph = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        for (int sheep : info) {
            if (sheep == 0) {
                totalSheep++;
            }
        }
        nextNodes = new HashSet<>(graph[0]);

        dfs(0, 1, 0);

        System.out.println(maxSheep);

    }

    private static void dfs(int node, int sheep, int wolf) {
        System.out.println("DFS 호출 : " + node);
//        System.out.println(node);

        if (maxSheep < sheep) {
            maxSheep = sheep;
        }

        if (totalSheep == sheep) {
            System.out.println("조건 리턴2");

            return;
        }

        if (nextNodes.isEmpty()) {
            System.out.println("조건 리턴3");

            return;
        }

        // 처음에 갈 수 있는 곳 1과 8
        //

        System.out.println(nextNodes);

        for (int next : new HashSet<>(nextNodes)) {
            int nextSheep = sheep;
            int nextWolf = wolf;
            if (info[next] == 0) {
                nextSheep++;
            }
            if (info[next] == 1) {
                nextWolf++;
            }

            if (nextSheep <= nextWolf) {
                System.out.println("갈필요 X" + next + "(양 토탈 : " + nextSheep + ")  / " + "늑대 : " + nextWolf);

                continue;
            }
            System.out.println(next + "(양 토탈 : " + nextSheep + ")  / " + "늑대 : " + nextWolf);
            nextNodes.remove(next);
            nextNodes.addAll(graph[next]);
            dfs(next, nextSheep, nextWolf);
            nextNodes.add(next);
            nextNodes.removeAll(graph[next]);
        }
        System.out.println("포문끝남");
    }
}
