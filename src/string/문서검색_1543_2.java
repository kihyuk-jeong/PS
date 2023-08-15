package string;

import java.util.Scanner;

public class 문서검색_1543_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String document = sc.nextLine();
        String word = sc.nextLine();

//        ababababa   = 9
//        aba  == 3
//        ba

        String replace = document.replace(word, "");
        int length = document.length() - replace.length();

        int result = length / word.length();

        System.out.println(result);
    }
}
