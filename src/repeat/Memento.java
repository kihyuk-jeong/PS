package repeat;

import java.util.Scanner;

public class Memento {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int studentCount = sc.nextInt();
        int testCount = sc.nextInt();

        int[][] score = new int[testCount][studentCount];

        for (int i = 0; i < testCount; i++) {
            for (int j = 0; j < studentCount; j++) {
                score[i][j] = sc.nextInt();
            }
        }

        solve(studentCount, testCount, score);
    }

    private static void solve(int studentCount, int testCount, int [][] score) {


        // 1. 학생별로 짝을 이루고, 각 시험마다 (멘토, 멘티) 가 가능한지 확인
        // 2. 입력은 등수 순으로 받기 때문에, N 번 학생이 몇등인지 찾아야 함
        // 3. 찾은 이후 등수가 멘토 < 멘티 가 되어야 함.
        // 4. 모든 시험에서 등수가 앞서야 하기 때문에, 모든 시험을 순회하면서 멘토<멘티 인 경우가 testCount 만큼 되어야 함.

        int answer = 0;

        for (int i = 1; i <= studentCount; i++) {
            for (int j = 1; j <= studentCount; j++) {

                int rankA = 0;
                int rankB = 0;
                int count = 0;

                for (int k = 0; k < testCount && i!=j; k++) {
                    for (int z = 0; z < studentCount; z++) {

                        if (score[k][z] == i) {
                            rankA = z;
                        }

                        if (score[k][z] == j) {
                            rankB = z;
                        }
                    }

                    if (rankA < rankB) {
                        count++;
                    }
                }

                if (count == testCount) {
                    answer++;
                }

            }
        }


        System.out.println(answer);


    }

}
