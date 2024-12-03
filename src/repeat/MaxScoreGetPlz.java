package repeat;

import java.util.Scanner;

class Temp2 {
    int score;
    int time;

    public Temp2(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class MaxScoreGetPlz {

    private static Temp2[] array;
    private static int n, limit;

    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        limit = sc.nextInt();

        array = new Temp2[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Temp2(sc.nextInt(), sc.nextInt());
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int level, int sum, int timeLimit) {

        if (limit < timeLimit) {
            return;
        }

        if (level == n) {
            answer = Math.max(sum, answer);
            return;
        }

        dfs(level + 1, sum + array[level].score, timeLimit + array[level].time);
        dfs(level + 1, sum, timeLimit);

    }

}
