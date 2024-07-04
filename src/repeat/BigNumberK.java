package repeat;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BigNumberK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(array, k);

    }

    private static void solve(int[] array, int k) {

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int z = j + 1; z < length; z++) {
                    set.add(array[i] + array[j] + array[z]);
                }
            }
        }

        int count = 0;

        for (int value : set) {

            count++;

            if (count == k) {
                System.out.println(value);
                break;
            }

        }

    }


}
