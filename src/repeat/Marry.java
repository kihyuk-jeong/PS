package repeat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Temp implements Comparable<Temp> {

    int time;
    String status;

    public Temp(int time, String status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Temp temp) {
        if (this.time == temp.time) {
            return this.status.compareTo(temp.status);
        }
        return this.time - temp.time;
    }
}


public class Marry {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Temp> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            list.add(new Temp(start, "s"));
            list.add(new Temp(end, "e"));
        }

        Collections.sort(list);

        int count = 0;
        int answer = Integer.MIN_VALUE;

        for (Temp temp : list) {
            String status = temp.status;

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
