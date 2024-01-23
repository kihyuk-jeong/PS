package string;

import java.util.Scanner;

public class 단어뒤집기3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] inputWords = new String[n];

        for (int i = 0; i < n; i++) {
            inputWords[i] = sc.next();
        }


        for (String word : inputWords) {

            char[] charArray = word.toCharArray();
            int lt = 0;
            int rt = charArray.length - 1;

            while(lt<rt) {

                char temp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = temp;

                lt++;
                rt--;
            }

            System.out.println(charArray);

        }


    }
}
