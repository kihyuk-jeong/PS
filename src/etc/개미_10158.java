package etc;

/**
 * 시간 초과..
 */

import java.util.Scanner;

public class 개미_10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();

        int startX = 1;
        int baseW = (t % (2 * w));
        int currentX = p;
        while (baseW-- > 0) {
            if (currentX == w) {
                startX = -1;
            } else if (currentX == 0) {
                startX = 1;
            }
            currentX += startX;

        }

        int startY = 1;
        int baseY = (t % (2 * h));
        int currentY = q;
        while (baseY-- > 0) {
            if (currentY == h) {
                startY = -1;
            } else if (currentX == 0) {
                startY = 1;
            }
            currentY += startY;
        }
        System.out.print(currentX + " " +currentY);
    }
}
