package news;
// 백준 : 11660번

import java.util.Scanner;

public class 구간합V2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int quizCount = sc.nextInt();

        int[][] originArray = new int[N][N];
        int[][] solveArray = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                originArray[i][j] = sc.nextInt();
            }
        }

        // 구간합 완성
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                solveArray[i][j] = solveArray[i][j - 1] + solveArray[i - 1][j] - solveArray[i - 1][j - 1] + originArray[i - 1][j - 1];
            }
        }

        for (int i = 0; i < quizCount; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            // (x1,y1) 부터 (x2,y2) 를 구하는 방법
            // (2,2) 부터 (3,4) 면 -> [x2,y2] - [(x1-1), y2]  - [x2 , (y1-1)] + (x1-1) + (y1-1)
            int answer = solveArray[x2][y2] - solveArray[x1 - 1][y2] - solveArray[x2][y1 - 1] + solveArray[x1 - 1][y1 - 1];
            System.out.println(answer);
        }

    }

}

