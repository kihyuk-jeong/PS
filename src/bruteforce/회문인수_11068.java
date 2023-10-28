package bruteforce;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11068
 */
public class 회문인수_11068 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        while (TC-- > 0) {

            int t = sc.nextInt();
            boolean isFind = false;
            for (int i = 2; i <= 64; i++) {
                int[] digit = getDigitArray(t, i);

                if (isValid(digit)) {
                    isFind = true;
                    break;
                }
            }

            System.out.println(isFind ? "1" : "0");

        }
    }

    private static boolean isValid(int[] digit) {
        for (int i = 0; i < digit.length / 2; i++) {
            if (digit[i] != digit[digit.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getDigitArray(int t, int i) {

        int len = 0;
        int copyT = t;
        while (copyT > 0) {
            copyT /= i;
            len++;
        }

        int[] arr = new int[len];
        int index = 0;
        while (t > 0) {
            arr[index++] = t % i;
            t /= i;
        }
        return arr;
    }

}
