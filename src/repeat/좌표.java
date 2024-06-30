package repeat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Pointer implements Comparable<Pointer> {

    int x;
    int y;

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pointer pointer) {

        if (this.x == pointer.x) {
            return this.y - pointer.y;
        }
        return this.x - pointer.x;
    }
}

public class 좌표 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Pointer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Pointer(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);


        for (Pointer pointer : list) {
            System.out.println(pointer.x + " " + pointer.y);
        }

    }
}
