package array;

import java.util.Scanner;

public class 중복제거2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        distinct(array);

    }

    private static void distinct(int[] array) {

        int length = array.length;

        int[] result = new int[length];
        int resultIndex = 0;

        for (int i = 0; i < length; i++) {
            boolean isDup = false;

            for (int j = 0; j < resultIndex; j++) {

                if (array[i] == result[j]) {
                    isDup = true;
                    break;
                }
            }

            if (!isDup) {
                result[resultIndex] = array[i];
                resultIndex++;
            }



        }

    }
}
