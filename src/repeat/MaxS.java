package repeat;

import java.util.Scanner;

class Tl {

    int score;
    int time;

    public Tl(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class MaxS {

    private static Tl[] arr;
    private static int n, limit;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        limit = sc.nextInt();

        arr = new Tl[n];


        // 점수, 시간
        for (int i = 0; i < n; i++) {
            arr[i] = new Tl(sc.nextInt(), sc.nextInt());
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int totalScore, int totalTime, int level) {

        if (totalTime > limit) {
            return;
        }

        if (level == n) {
            answer = Math.max(totalScore, answer);
            return;
        }

        dfs(totalScore + arr[level].score, totalTime + arr[level].time, level + 1);
        dfs(totalScore, totalTime, level+1);

    }
}
