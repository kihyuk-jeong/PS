package array;

import java.util.Scanner;

public class 성지키키_1236 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int castleX = 0;
        int castleY = 0;

        char[][] castle = new char[N][M];

        for (int i = 0; i < N; i++) {
            castle[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            boolean isExist = false;
            for (int j = 0; j < M; j++) {
                if (castle[i][j] == 'X') {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                castleX++;
            }
        }

        for (int i = 0; i < M; i++) {
            boolean isExist = false;
            for (int j = 0; j < N; j++) {
                if (castle[j][i] == 'X') {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                castleY++;
            }
        }

        int a = N - castleX;
        int b = M - castleY;

        System.out.println(Math.max(a, b));
    }
}
