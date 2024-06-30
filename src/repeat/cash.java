package repeat;

import java.util.Scanner;

public class cash {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cacheSize = sc.nextInt();
        int workSize = sc.nextInt();

        int[] workers = new int[workSize];

        for (int i = 0; i < workSize; i++) {
            workers[i] = sc.nextInt();
        }

        solve(cacheSize, workSize, workers);
    }

    private static void solve(int cacheSize, int workSize, int[] workers) {

        int[] cache = new int[cacheSize];

        for (int i = 0; i < workSize; i++) {

            int worker = workers[i];

            if (isCacheHit(cache, worker)) {
                cacheHit(cache, worker);
            } else {
                cacheMiss(cache, worker);
            }
        }

        for (int worker : cache) {
            System.out.print(worker + " ");
        }
    }

    public static boolean isCacheHit(int[] caches, int worker) {

        for (int cache : caches) {
            if (cache == worker) {
                return true;
            }
        }

        return false;
    }

    private static void cacheMiss(int[] caches, int worker) {

        int length = caches.length;

        for (int i = length - 2; i >= 0; i--) {
            caches[i + 1] = caches[i];
        }
        caches[0] = worker;
    }

    private static void cacheHit(int[] caches, int worker) {

        int length = caches.length;
        int index = -1;

        for (int i = 0; i < length; i++) {
            if (caches[i] == worker) {
                index = i;
            }
        }

        for (int i = index - 2; i >= 0; i--) {
            caches[i + 1] = caches[i];
        }
        caches[0] = worker;
    }
}
