package string;

import java.util.Scanner;

public class Search2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String document = sc.nextLine();
        String word = sc.nextLine();

        int startIndex = 0;
        int result = 0;

        while (true) {

            int searchIndex = document.indexOf(word, startIndex);

            if (searchIndex < 0) {
                break;
            }

            result++;
            startIndex = searchIndex + word.length();
        }

        System.out.println(result);

    }
}
