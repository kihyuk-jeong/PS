package repeat;

import java.util.Scanner;

public class 구간합구하기_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int quizCount = sc.nextInt();

        int[][] array = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int[][] solveArray = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                solveArray[i][j] = solveArray[i - 1][j] + solveArray[i][j - 1] - solveArray[i - 1][j - 1] + array[i][j];
            }
        }

        for (int i = 0; i < quizCount; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int answer = solveArray[x2][y2] - solveArray[x1 - 1][y2] - solveArray[x2][y1 - 1]
                    + solveArray[x1 - 1][y1 - 1];

            System.out.println(answer);
        }
    }
}
