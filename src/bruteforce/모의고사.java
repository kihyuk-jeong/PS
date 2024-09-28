package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 모의고사 {

    private static final int[][] human = {{1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] answers = new int[n];


        for (int i = 0; i < n; i++) {
            answers[i] = sc.nextInt();
        }

        List<Integer> solution = solution(answers);

        System.out.println(solution);
    }

    private static List<Integer> solution(int[] answers) {

        int answerLength = answers.length;

        int[] scores = new int[3];


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < answerLength; j++) {
                int length = human[i].length;
                if (answers[j] == human[i][j % length]) {
                    scores[i]++;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int max = Arrays.stream(scores).max().getAsInt();

        for (int i = 0; i < 3; i++) {
            if (scores[i] == max) {
                list.add(i + 1);
            }
        }

        return list;


    }
}
