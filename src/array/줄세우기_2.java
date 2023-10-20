package array;

import java.util.Scanner;

public class 줄세우기_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();

        while (P-- > 0) {

            int t = sc.nextInt();
            int count = 0;
            int[] students = new int[20];
            int[] sortedStudents = new int[20];

            for (int i = 0; i < 20; i++) {
                students[i] = sc.nextInt();
            }

            for (int i = 0; i < 20; i++) {
                boolean isFind = false;
                for (int j = 0; j < i; j++) {
                    if (sortedStudents[j] > students[i]) {
                        isFind = true;

                        for (int k = i - 1; k >= j; k--) {
                            sortedStudents[k + 1] = sortedStudents[k];
                            count++;
                        }
                        sortedStudents[j] = students[i];
                        break;
                    }

                }

                if (!isFind) {
                    sortedStudents[i] = students[i];
                }
            }
            System.out.println(t + " " + count);
        }
    }
}
