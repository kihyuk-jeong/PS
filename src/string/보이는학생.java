package string;

import java.util.Scanner;

public class 보이는학생 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int max = 0;
        int count = 0;
        for (int i = 0; i < tc; i++) {

            int input = sc.nextInt();

            if (max < input) {
                count++;
                max = input;
            }
        }


        System.out.println(count);

    }
}
