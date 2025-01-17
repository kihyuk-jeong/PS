package repeat.more;

import java.util.Arrays;
import java.util.Scanner;

public class 중복체크 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);

        if (isDup(array)) {
            System.out.println("D");
        } else {
            System.out.println("U");
        }
    }

    private static boolean isDup(int[] array) {
        int n = array.length;

        for (int i = n - 1; i >= 1; i--) {
            if (array[i] == array[i - 1]) {
                return true;
            }
        }
        return false;
    }
}