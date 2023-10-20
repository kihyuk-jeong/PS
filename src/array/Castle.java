package array;

import java.util.Scanner;

public class Castle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int indexX = sc.nextInt();
        int indexY = sc.nextInt();

        char[][] castle = new char[indexX][indexY];

        for (int i = 0; i < indexX; i++) {
            castle[i] = sc.next().toCharArray();
        }

        int x = indexX;
        int y = indexY;

        for (int i = 0; i < indexX; i++) {
            for (int j = 0; j < indexY; j++) {
                if (castle[i][j] == 'X') {
                    x--;
                    break;
                }
            }
        }

        for (int i = 0; i < indexY; i++) {
            for (int j = 0; j < indexX; j++) {
                if (castle[j][i] == 'X') {
                    y--;
                    break;
                }
            }
        }

        System.out.println(Math.max(x, y));
    }
}
