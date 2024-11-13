package repeat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class MeetRoom implements Comparable<MeetRoom> {
    int start;
    int end;

    // 끝나는 시간이 빠른 순으로 정렬을 해야하니까, 끝나는 시간 오름차순이 기본.
    // 끝나는 시간이 동일하다면 시작하는 시간 오름차순
    @Override
    public int compareTo(MeetRoom meetRoom) {
        if (meetRoom.end == this.end) {
            return this.start - meetRoom.start;
        }

        return  this.end-meetRoom.end;
    }

    public MeetRoom(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "MeetRoom{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class 미트룸 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<MeetRoom> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new MeetRoom(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);

        int endMax = Integer.MIN_VALUE;
        int count = 0;

        for (MeetRoom meetRoom : list) {
            int start = meetRoom.start;
            int end = meetRoom.end;

            if (endMax <= start) {
                count++;
                endMax = end;
            }
        }

        System.out.println(count);


    }
}