package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 중복제거 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Integer[] answer = Arrays.stream(array).boxed()
                .distinct()
                .toArray(Integer[]::new);

        Arrays.sort(answer, Comparator.reverseOrder());

    }
}
