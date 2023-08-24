package string;

import java.util.Scanner;

/**
 * 모든 시간을 '초' 로 변경해서 해결
 * 시간 = x /3600 , 분 = (x % 3600) / 60, 초 = x % 60
 */

public class 소금폭탄_13223_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String now = sc.nextLine();
        String drop = sc.nextLine();

        String[] nowArr = now.split(":");
        String[] dropArr = drop.split(":");

        int nowTotalSecond = (Integer.parseInt(nowArr[0]) * 3600) + (Integer.parseInt(nowArr[1]) * 60) + (Integer.parseInt(nowArr[2]));
        int dropTotalSecond = (Integer.parseInt(dropArr[0]) * 3600) + (Integer.parseInt(dropArr[1]) * 60) + (Integer.parseInt(dropArr[2]));

        int resultTotalSecond = dropTotalSecond - nowTotalSecond;
        if (resultTotalSecond <= 0) {
            resultTotalSecond += (24 * 3600);
        }

        int resultHour = resultTotalSecond / 3600;
        int resultMin = (resultTotalSecond % 3600) / 60;
        int resultSecond = resultTotalSecond % 60;

        System.out.printf("%02d:%02d:%02d", resultHour, resultMin, resultSecond);
    }
}
