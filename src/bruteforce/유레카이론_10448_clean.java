package bruteforce;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10448
 */

public class 유레카이론_10448_clean {
    static boolean[] isEurekaNumber = new boolean[1001];

    private static void preprocess() {

        // 1. 1000 이하의 모든 삼각수를 구한다.
        int[] triangleNumbers = new int[50];
        int triangleIndex = 0;

        for (int i = 1; i < 50; i++) {
            int sum = i * (i + 1) / 2;
            if (sum <= 1000) {
                triangleNumbers[triangleIndex++] = sum;
            }
        }

        // 2. 유레카 넘버를 구한다.

        boolean[] isMaybeTriangleNumbers = new boolean[1000];

        for (int i = 0; i < triangleIndex; i++) {
            for (int j = 0; j < triangleIndex; j++) {
                int sum = triangleNumbers[i] + triangleNumbers[j];
                if (sum < 1000) {
                    isMaybeTriangleNumbers[sum] = true;
                }
            }
        }

        for (int i = 1; i < 1000; i++) {
            if(!isMaybeTriangleNumbers[i]) {
                continue;
            }
            for (int j = 0; j < triangleIndex; j++) {
                int sum = i + triangleNumbers[j];
                if(sum <=1000) {
                    isEurekaNumber[sum] = true;
                }
            }
        }


    }
    public static void main(String[] args) {

        preprocess();

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        while (tc-- > 0) {
            int k = sc.nextInt();

            System.out.println(isEurekaNumber[k] ? "1" : "0");

        }
    }
}
