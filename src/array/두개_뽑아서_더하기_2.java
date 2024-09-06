package array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 단순 완전탐색
 */
public class 두개_뽑아서_더하기_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                set.add(array[i] + array[j]);
            }
        }

        System.out.println(set);


    }
}
