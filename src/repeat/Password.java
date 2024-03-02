package repeat;

import java.util.ArrayList;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String password = sc.next();

        solve(n, password);


    }

    private static void solve(int n, String password) {

        ArrayList<Character> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String partition = password.substring(0, 7);

            String replace = partition.replace("#", "1").replace("*", "0");

            int binaryNumber = Integer.parseInt(replace, 2);

            char charNumber = (char) binaryNumber;
            answer.add(charNumber);

            password = password.substring(7);

        }

        for (char c : answer) {
            System.out.print(c);
        }

    }
}
