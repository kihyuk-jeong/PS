package string;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] inputWords = new String[n];

        for (int i = 0; i < n; i++) {
            inputWords[i] = sc.next();
        }

        ArrayList<String> answer = new ArrayList<>();

        for (String word : inputWords) {

            StringBuilder builder = new StringBuilder(word);
            answer.add(builder.reverse().toString());
        }


        for (String ans : answer) {
            System.out.println(ans);
        }


    }
}
