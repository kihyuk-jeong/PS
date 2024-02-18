package repeat;

import java.util.Scanner;

public class Mountain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(n, array));
    }

    public static int solve(int n, int[][] array) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                boolean isTrue = true;
                for (int k = 0; k < 4; k++) {

                    int px = i + dx[k];
                    int py = j + dy[k];

                    if (px >= 0 && px < n && py >= 0 && py < n && array[i][j] <= array[px][py]) {
                        isTrue = false;
                        break;
                    }
                }


                if (isTrue) {
                    count++;
                }

            }

        }

        return count;

    }


}
