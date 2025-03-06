package repeat.more;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class K큰 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                for (int z = y + 1; z < n; z++) {
                    set.add(arr[x] + arr[y] + arr[z]);
                }
            }
        }

        int index = 0;
        int answer = 0;
        for (Integer value : set) {
            index++;

            if (index == k) {
                answer = value;
                break;
            }
        }

        System.out.println(answer);

    }
}
