package string.re._1543;

import java.util.Scanner;
//a b c a b c

public class _1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String document = sc.nextLine();
        String text = sc.nextLine();

        int count = 0;
        int startIndex = 0;

        while (true) {

            int findIndex = document.indexOf(text, startIndex);

            if (findIndex < 0) {
                break;
            }

            count++;
            startIndex = text.length() + findIndex;

        }

        System.out.println(count);


    }
}
