package greedy;

import java.util.Arrays;
import java.util.Scanner;

class Room implements Comparable<Room> {
    int start;
    int end;

    public Room(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room room) {

        if (this.end == room.end) {
            return this.start - room.start;
        }

        return this.end - room.end;
    }
}

public class 회의실 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            rooms[i] = new Room(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(rooms);

        int count = 1;
        int minEnd = rooms[0].end;

        for (int i = 1; i < n; i++) {
            int cuStart = rooms[i].start;
            int cuEnd = rooms[i].end;

            if (minEnd <= cuStart) {
                minEnd = cuEnd;
                count++;
            }

        }

        System.out.println(count);


    }


}
