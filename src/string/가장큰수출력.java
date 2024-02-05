package string;

import java.util.Scanner;

public class 가장큰수출력 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int[] array = new int[tc];

        for (int i = 0; i < tc; i++) {
            array[i] = sc.nextInt();
        }

        String solve = solve(array);
        System.out.println(solve);
    }

    private static String solve(int[] array) {

        StringBuilder builder = new StringBuilder();
        builder.append(array[0]);


        for (int i = 0; i < array.length; i++) {

            if (i + 1 < array.length && array[i] < array[i + 1]) {
                builder.append(" ").append(array[i + 1]);
            }
        }

        return builder.toString();
    }
}
