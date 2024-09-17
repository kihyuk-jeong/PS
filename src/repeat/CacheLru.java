package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class CacheLru {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cacheSize = sc.nextInt();
        int workSize = sc.nextInt();

        int[] cache = new int[cacheSize];
        int[] works = new int[workSize];

        for (int i = 0; i < workSize; i++) {
            works[i] = sc.nextInt();
        }

        int[] result = start(cache, works);

        System.out.println(Arrays.toString(result));

    }

    private static int[] start(int[] cache, int[] works) {

        int cacheSize = cache.length;
        int workSize = works.length;

        for (int i = 0; i < workSize; i++) {

            int currentWork = works[i];

            if (cacheHit(cache, currentWork)) {

                int cacheIndex = getIndex(cache, currentWork);

                for (int j = cacheIndex - 1; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }
            } else {
                for (int j = cacheSize - 2; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }

            }
            cache[0] = currentWork;
        }

        return cache;

    }

    private static int getIndex(int[] cache, int currentWork) {

        int cacheSize = cache.length;

        for (int i = 0; i < cacheSize; i++) {

            if (cache[i] == currentWork) {
                return i;
            }

        }
        return -1;
    }

    private static boolean cacheHit(int[] cache, int currentWork) {

        for (int value : cache) {
            if (value == currentWork) {
                return true;
            }
        }

        return false;
    }
}
