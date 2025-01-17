package repeat.more;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class P implements Comparable<P> {

    int x;
    int y;

    @Override
    public int compareTo(P o) {

        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }

    public P(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 좌표 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<P> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new P(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(arr);

        for (P value : arr) {
            System.out.print(value.x + " " + value.y);
            System.out.println();
        }


    }
}
