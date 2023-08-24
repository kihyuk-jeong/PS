package array;

import java.util.Scanner;

public class 성지키키_1236_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] castle = new char[N][M];

        for (int i = 0; i < N; i++) {
            castle[i] = sc.next().toCharArray();
        }

        int castleX = N;
        int castleY = M;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (castle[i][j] == 'X') {
                    castleX--;
                    break;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (castle[j][i] == 'X') {
                    castleY--;
                    break;
                }
            }
        }

        System.out.println(Math.max(castleX, castleY));
    }
}
