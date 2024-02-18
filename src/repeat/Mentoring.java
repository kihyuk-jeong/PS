package repeat;

import java.util.Scanner;

public class Mentoring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int tc = sc.nextInt();

        int[][] ranking = new int[tc][n];

        for (int i = 0; i < tc; i++) {
            for (int j = 0; j < n; j++) {
                ranking[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(n, tc, ranking));
    }

    public static int solve(int numberOfStudents, int testCase, int[][] ranking) {

        int count;
        int answer = 0;
        int positionI = 0;
        int positionJ = 0;

        for (int i = 1; i <= numberOfStudents; i++) {
            for (int j = 1; j <= numberOfStudents; j++) {

                count = 0;

                for (int k = 0; k < testCase && i!=j; k++) {
                    for (int z = 0; z < numberOfStudents; z++) {

                        if (ranking[k][z] == i) {
                            positionI = z;
                        }

                        if (ranking[k][z] == j) {
                            positionJ = z;
                        }
                    }

                    if (positionI < positionJ) {
                        count++;
                    }
                }

                if (count == testCase) {
                    answer++;
                }

            }
        }

        return answer;

    }
}
