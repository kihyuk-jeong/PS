package array;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10431
public class 줄세우기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();

        while (P-- > 0) {

            int T = sc.nextInt();
            int result = 0;
            int[] student = new int[20];

            for (int i = 0; i < 20; i++) {
                student[i] = sc.nextInt();
            }

            int[] sorted = new int[20];

            for (int i = 0; i < 20; i++) {
                boolean isFind = false;
                for (int j = 0; j < i; j++) {
                    if (sorted[j] > student[i]) {
                        isFind = true;
                        for (int k = i - 1; k >= j; k--) {
                            sorted[k + 1] = sorted[k];
                            result++;
                        }
                        sorted[j] = student[i];
                        break;
                    }
                }

                if (!isFind) {
                    sorted[i] = student[i];
                }
            }

            System.out.println(T + " " + result);
        }
    }
}
