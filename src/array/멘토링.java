package array;

import java.util.Scanner;

public class 멘토링 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] array = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(n, m, array));

    }

    private static int solve(int n, int m, int[][] array) {

        // n : 학생수
        // m : 시험수

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println(i + "," + j);
                int count = 0;
                for (int tc = 0; tc < m; tc++) {

                    int pi = 0;
                    int pj = 0;

                    for (int rank = 0; rank < n; rank++) {

                        if (array[tc][rank] == i) {
                            pi = rank;
                        }

                        if (array[tc][rank] == j) {
                            pj = rank;
                        }
                    }
                    if (pi < pj) {
                        count++;
                    }
                }
                if (count == m) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
