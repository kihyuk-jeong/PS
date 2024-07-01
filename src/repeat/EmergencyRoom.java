package repeat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pri {
    int index;
    int priority;

    public Pri(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Pri{" +
                "index=" + index +
                ", priority=" + priority +
                '}';
    }
}

public class EmergencyRoom {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(n, m, array);
    }

    private static void solve(int n, int m, int[] array) {

        Queue<Pri> queue = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            queue.offer(new Pri(i, array[i]));
        }

        int count = 0;

        while (!queue.isEmpty()) {

            boolean isFind = true;

            Pri current = queue.poll();

            for (Pri pri : queue) {
                if (current.priority < pri.priority) {
                    isFind = false;
                    break;
                }
            }

            if (isFind) {
                count++;

                if (current.index == m) {
                    break;
                }
            } else {
                queue.offer(current);
            }
        }

        System.out.println(count);


    }
}
