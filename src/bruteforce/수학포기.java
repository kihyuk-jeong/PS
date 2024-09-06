package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 수학포기 {

    static int[][] array = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = sc.nextInt();
        }


        int[] score = getScore(answer);

        int max = Arrays.stream(score).max().getAsInt();

        ArrayList<Integer> index = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (max == score[i]) {
                index.add(i + 1);
            }
        }

        System.out.println(index);

    }

    private static int[] getScore(int[] answer) {

        System.out.println(array.length);

        int count = answer.length;

        int[] score = new int[3];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < array.length; j++) {

                if (answer[i] == array[j][i % array[j].length]) {
                    score[j]++;
                }

            }
        }
        return score;
    }
}
