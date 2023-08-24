package string;

import java.util.Scanner;

/**
 * 매우 간단하게 풀 수 있는 문제인데, 정답률이 38%인 이유는 아마 24:00:00 의 조건을 제외해서..?
 * 그냥 뺄셈 문제다. 모자라면 옆에서 빌려오는.
 */

public class 소금폭탄_13223 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String currentTime = sc.nextLine();
        String dropTime = sc.nextLine();

        String[] currentTimeArr = currentTime.split(":");
        String[] dropTimeArr = dropTime.split(":");

        int currentSec = Integer.parseInt(currentTimeArr[2]);
        int currentMin = Integer.parseInt(currentTimeArr[1]);
        int currentHour = Integer.parseInt(currentTimeArr[0]);

        int dropSec = Integer.parseInt(dropTimeArr[2]);
        int dropMin = Integer.parseInt(dropTimeArr[1]);
        int dropHour = Integer.parseInt(dropTimeArr[0]);

        int needSec = dropSec - currentSec;
        if (needSec < 0) {
            dropMin--;
            needSec = (dropSec + 60) - currentSec;
        }

        int needMin = dropMin - currentMin;
        if (needMin < 0) {
            dropHour--;
            needMin = (dropMin + 60) - currentMin;
        }

        int needHour = (dropHour - currentHour) + 24;
        if (needHour > 24) {
            needHour -= 24;
        }

        System.out.printf("%02d:%02d:%02d", needHour, needMin, needSec);

    }
}
