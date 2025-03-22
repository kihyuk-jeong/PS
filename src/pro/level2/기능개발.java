package pro.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
    public static void main(String[] args) {

        int[] progresses = {95,90,99,99,80,99};
        int[] speeds = {1,1,1,1,1,1};

//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};

        List<Integer> answer = solve(progresses, speeds);
        System.out.println(answer);

    }

    private static List<Integer> solve(int[] progresses, int[] speeds) {

        int length = progresses.length;
        int[] times = new int[length];

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < length; i++) {

            int count = 0;
            int progress = progresses[i];
            int speed = speeds[i];

            while (progress < 100) {
                count++;
                progress += speed;
            }
            times[i] = count;
        }

        System.out.println(Arrays.toString(times));
        int count = 0;
        int base = times[0];

        for (int i = 0; i < length; i++) {

            if (base >= times[i]) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                base = times[i];
            }
        }

        answer.add(count);
        return answer;

    }
}
