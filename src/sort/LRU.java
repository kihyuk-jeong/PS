package sort;

import java.util.Scanner;

/**
 *  O(n * s)
 */
public class LRU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();

        int[] cache = new int[s];
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        solve(cache, input);
    }

    private static void solve(int[] cache, int[] input) {

        int cacheSize = cache.length;
        int inputSize = input.length;

        for (int i = 0; i < inputSize; i++) {

            if (isCacheHit(cache, input[i])) {

                int index = getIndex(cache, input[i]);

                for (int j = index - 1; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }

            } else {
                for (int j = cacheSize - 2; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }

            }
            cache[0] = input[i];

        }

        // print
        for (int value : cache) {
            System.out.print(value + " ");
        }

    }

    private static int getIndex(int[] cache, int value) {

        int index = -1;

        for (int i = 0; i < cache.length; i++) {

            if (cache[i] == value) {
                index = i;
            }
        }
        return index;
    }

    private static boolean isCacheHit(int[] cache, int value) {

        boolean isHit = false;

        for (int j : cache) {
            if (j == value) {
                isHit = true;
                break;
            }
        }

        return isHit;
    }
}
