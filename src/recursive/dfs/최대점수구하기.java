package recursive.dfs;

import java.util.Scanner;

class Grade {
    int score;
    int ttl;

    public Grade(int score, int ttl) {
        this.score = score;
        this.ttl = ttl;
    }
}

public class 최대점수구하기 {

    private static Grade[] grades;
    private static int answer = Integer.MIN_VALUE;
    private static int n;
    private static int limit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        limit = sc.nextInt();
        grades = new Grade[n];

        for (int i = 0; i < n; i++) {

            int score = sc.nextInt();
            int ttl = sc.nextInt();

            grades[i] = new Grade(score, ttl);
        }

        recursive2(0, 0, 0);

        System.out.println(answer);
    }

    private static void recursive(int index, int scoreSum, int timeSum) {


        if (timeSum > limit) {
            return;
        }

        if (index == n) {

            answer = Math.max(scoreSum, answer);
            return;
        }
        recursive(index + 1, scoreSum + grades[index].score, timeSum + grades[index].ttl);
        recursive(index + 1, scoreSum, timeSum);
    }

    private static void recursive2(int start, int scoreSum, int timeSum) {

        if (timeSum > limit) {
            return;
        }

        answer = Math.max(scoreSum, answer);

        for (int i = start; i < n; i++) {
            recursive2(i + 1, scoreSum + grades[i].score, timeSum + grades[i].ttl);
        }
    }
}
