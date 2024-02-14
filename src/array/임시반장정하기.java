package array;

import java.util.Scanner;

public class 임시반장정하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] students = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                students[i][j] = sc.nextInt();
            }
        }


        System.out.println(solve(students, n));
    }

    public static int solve(int[][] students, int n) {

        int answer = 0;
        int countBefore =Integer.MIN_VALUE;
        int count;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5 && i != j; k++) {
                    if (students[i][k] == students[j][k]) {
                        count++;
                        break;
                    }
                }
            }

            if (count > countBefore) {
                countBefore = count;
                answer = i;

            }
        }

        return answer + 1;
    }
}
