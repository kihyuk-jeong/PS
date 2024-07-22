package repeat;

import java.util.ArrayList;
import java.util.Scanner;

public class Aarmho {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String input = sc.next();

        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String temp =input.substring(0, 7);

            String replace = temp.replace("#", "1").replace("*", "0");

            int binaryNumber = Integer.parseInt(replace, 2);

            list.add((char) binaryNumber);

            input = input.substring(7);
        }

        System.out.println(list);


    }
}
