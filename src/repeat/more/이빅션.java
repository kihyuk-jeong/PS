package repeat.more;

import java.util.Scanner;

public class 이빅션 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cacheSize = sc.nextInt();
        int n = sc.nextInt();

        int[] array = new int[n];
        int[] cache = new int[cacheSize];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }


        for (int i = 0; i < n; i++) {
            int value = array[i];

            if (isCacheHit(value, cache)) {

                int index = getIndex(value, cache);

                for (int j = index; j >= 1; j--) {
                    cache[j] = cache[j - 1];
                }
            } else {
                for (int j = cacheSize - 1; j >= 1; j--) {
                    cache[j] = cache[j - 1];
                }
            }
            cache[0] = value;

        }

        for (int cacheValue : cache) {
            System.out.print(cacheValue + " ");
        }

    }

    private static int getIndex(int value, int[] cache) {

        int length = cache.length;

        for (int i = 0; i < length; i++) {
            if (value == cache[i]) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isCacheHit(int value, int[] caches) {


        for (int cacheValue : caches) {
            if (cacheValue == value) {
                return true;
            }

        }
        return false;
    }
}
