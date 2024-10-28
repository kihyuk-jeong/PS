package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    int value;
    String status;

    public Time(int value, String statue) {
        this.value = value;
        this.status = statue;
    }
    @Override
    public int compareTo(Time other) {
        if (this.value == other.value) {
            return this.status.compareTo(other.status);
        }
        return Integer.compare(this.value, other.value);
    }
}

public class 결혼식 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int start = sc.nextInt();
            int end = sc.nextInt();

            list.add(new Time(start, "s"));
            list.add(new Time(end, "e"));
        }

        Collections.sort(list);

        int count = 0;
        int answer = 0;

        for (Time time : list) {
            String status = time.status;

            if ("s".equals(status)) {
                count++;
            } else {
                count--;
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);


    }
}
