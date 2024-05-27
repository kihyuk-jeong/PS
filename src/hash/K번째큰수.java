package hash;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class K번째큰수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(array, n, k);
    }

    private static void solve(int[] array, int n, int k) {

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int z = j+1; z < n; z++) {
                    int sum = array[i] + array[j] + array[z];
                    set.add(sum);
                }
            }

        }

        int count = 0;
        int answer = -1;

        for (Integer value : set) {
            count++;

            if (count == k) {
                answer = value;
                break;
            }

        }

        System.out.println(answer);

    }
}
