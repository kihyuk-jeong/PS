package bruteforce;

import java.util.Scanner;


public class 사탕게임_3085_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    swapCandy(map, i, j, i, j + 1);
                    ans = Math.max(ans, Math.max(findMaxRow(map), findMaxCol(map)));
                    swapCandy(map, i, j, i, j + 1);
                }
                if (i + 1 < N && map[i][j] != map[i+1][j]) {
                    swapCandy(map, i, j, i+1, j);
                    ans = Math.max(ans, Math.max(findMaxRow(map), findMaxCol(map)));
                    swapCandy(map, i, j, i+1, j);
                }

            }
        }

        System.out.println(ans);
    }



    private static int findMaxRow(char[][] map) {

        int N = map.length;
        int maxRow = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            char current = map[i][0];
            for (int j = 0; j < N; j++) {
                if (map[i][j] == current) {
                    count++;
                } else {
                    current = map[i][j];
                    count =1;
                }

                maxRow = Math.max(count, maxRow);
            }
        }
        return maxRow;
    }

    private static int findMaxCol(char[][] map) {

        int N = map.length;
        int maxCol = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            char current = map[0][i];

            for (int j = 0; j < N; j++) {
                if (map[j][i] == current) {
                    count++;
                } else {
                    current = map[j][i];
                    count = 1;
                }
                maxCol = Math.max(count, maxCol);
            }
        }
        return maxCol;
    }

    private static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }
}
