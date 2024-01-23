package string;

import java.util.Scanner;

public class 단어뒤집기2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] inputWords = new String[n];

        for (int i = 0; i < n; i++) {
            inputWords[i] = sc.next();

            for (int j = inputWords[i].length()-1; j >= 0; j--) {
                System.out.print(inputWords[i].charAt(j));
            }
            System.out.println();
        }

    }
}
