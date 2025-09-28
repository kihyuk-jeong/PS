package news;

import java.util.Scanner;

public class DnaPassword {

    private static int checkPoint = 0;
    private static int[] checkArray;
    private static int[] myArray;

    private static int TARGET_POINT = 4;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int p = sc.nextInt();

        String dna = sc.next();

        char[] dnaArray = dna.toCharArray();
        checkArray = new int[4];
        myArray = new int[4];
        for (int i = 0; i < 4; i++) {
            int value = sc.nextInt();
            checkArray[i] = value;

            if (value == 0) {
                checkPoint++;
            }

        }

        int answer = 0;

        // 1. 초기셋팅
        for (int i = 0; i < p; i++) {
            add(dnaArray[i]);
        }

        if (checkPoint == TARGET_POINT) {
            answer++;
        }

        // 2. 슬라이딩 윈도우 처리
        for (int i = p; i < s; i++) {
            int j = i - p;
            add(dnaArray[i]);
            remove(dnaArray[j]);

            if (checkPoint == TARGET_POINT) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static void add(char dna) {

        switch (dna) {
            case 'A' -> {
                myArray[0]++;
                if (myArray[0] == checkArray[0]) {
                    checkPoint++;
                }
            }
            case 'C' -> {
                myArray[1]++;
                if (myArray[1] == checkArray[1]) {
                    checkPoint++;
                }
            }
            case 'G' -> {
                myArray[2]++;
                if (myArray[2] == checkArray[2]) {
                    checkPoint++;
                }
            }
            case 'T' -> {
                myArray[3]++;
                if (myArray[3] == checkArray[3]) {
                    checkPoint++;
                }
            }
        }
    }

    private static void remove(char dna) {

        switch (dna) {
            case 'A' -> {
                if (myArray[0] == checkArray[0]) {
                    checkPoint--;
                }
                myArray[0]--;
            }
            case 'C' -> {
                if (myArray[1] == checkArray[1]) {
                    checkPoint--;
                }
                myArray[1]--;
            }
            case 'G' -> {
                if (myArray[2] == checkArray[2]) {
                    checkPoint--;
                }
                myArray[2]--;

            }
            case 'T' -> {
                if (myArray[3] == checkArray[3]) {
                    checkPoint--;
                }
                myArray[3]--;
            }
        }
    }


}