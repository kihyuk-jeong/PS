import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        while (TC-- > 0) {

            int t = sc.nextInt();
            boolean isFind = false;
            for (int i = 2; i < 64; i++) {
                int[] digit = getDigit(i, t);
                if (isValid(digit)) {
                    isFind = true;
                }
            }

            if (isFind) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }


    }

    private static boolean isValid(int[] digit) {

        int length = digit.length / 2;

        for (int i = 0; i < length; i++) {
            if (digit[i] != digit[digit.length - 1 - i]) {
                return false;
            }
        }

        return true;

    }

    private static int[] getDigit(int i, int t) {

        int arraySize = 0;
        int temp = t;
        while (temp > 0) {
            temp /= i;
            arraySize++;
        }

        int[] array = new int[arraySize];
        int index = 0;
        while (t > 0) {
            array[index++] = t % i;
            t /= i;
        }
        return array;
    }
}