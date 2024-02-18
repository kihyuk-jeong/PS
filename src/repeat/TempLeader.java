package repeat;

import java.util.Scanner;

public class TempLeader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] array = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(n, array));
    }

    public static int solve(int n, int[][] array) {

        int answer = 0;

        int max = 0;
        int min = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            max = 0;
            for (int j = 0; j < n; j++) {

                for (int k = 0; i != j && k < 5; k++) {

                    if (array[i][k] == array[j][k]) {
                        max++;
                        break;
                    }
                }
            }

            if (max > min) {
                min = max;
                answer = i;
            }


        }
        return answer+1;
    }


}
