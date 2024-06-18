package sort;

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point point) {
        if (this.x == point.x) {
            return this.y - point.y;
        } else {
            return this.x - point.x;
        }
    }


}

public class PointSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);

        for (Point point : list) {
            System.out.print(point.x + " " + point.y);
            System.out.println();
        }


    }
}
