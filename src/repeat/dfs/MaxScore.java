package repeat.dfs;

import java.util.Scanner;

class Qus {
    int score;
    int time;

    public Qus(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class MaxScore {

    private static int count, limit;
    private static Qus[] array;

    private static int maxScore = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();
        limit = sc.nextInt();

        array = new Qus[count];

        for (int i = 0; i < count; i++) {
            array[i] = new Qus(sc.nextInt(), sc.nextInt());
        }

        dfs2(0, 0, 0);

        System.out.println(maxScore);
    }

    private static void dfs(int level, int timeSum, int scoreSum) {

        if (timeSum > limit) {
            return;
        }

        if (level == count) {
            maxScore = Math.max(maxScore, scoreSum);
            return;
        }

        dfs(level + 1, timeSum + array[level].time, scoreSum + array[level].score);
        dfs(level + 1, timeSum, scoreSum);
    }

    private static void dfs2(int startIndex, int timeSum, int scoreSum) {

        if (limit < timeSum) {
            return;
        }

        maxScore = Math.max(maxScore, scoreSum);

        for (int i = startIndex; i < count; i++) {
            dfs2(i + 1, timeSum + array[i].time, scoreSum + array[i].score);
        }
    }
}
