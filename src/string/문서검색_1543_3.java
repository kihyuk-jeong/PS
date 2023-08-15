package string;

import java.util.Scanner;

public class 문서검색_1543_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String document = sc.nextLine();
        String word = sc.nextLine();

        int result = 0;
        int startIndex = 0;

        while (true) {

            int searchResult = document.indexOf(word, startIndex);

            if (searchResult < 0) {
                break;
            }
            startIndex = word.length() + searchResult;
            result++;
        }

        System.out.println(result);
    }
}
