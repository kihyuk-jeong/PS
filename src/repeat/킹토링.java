package repeat;

import java.util.Scanner;

public class 킹토링 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 학생 수
        int n = sc.nextInt();

        // 테스트 횟수
        int m = sc.nextInt();

        int[][] array = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }


        solve(n, m, array);
    }

    private static void solve(int n, int tc, int[][] array) {

        int answer = 0;
        int count = 0;

        int current = 0;
        int next = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                for (int k = 0; k < tc && i != j; k++) {
                    for (int z = 0; z < n; z++) {

                        if (array[k][z] == i) {
                            current = z;
                        }

                        if (array[k][z] == j) {
                            next = z;
                        }
                    }

                    if (current < next) {
                        count++;
                    }
                }

                if (count == tc) {
                    answer++;
                }
                count = 0;
            }
        }

        System.out.println(answer);
    }
}
