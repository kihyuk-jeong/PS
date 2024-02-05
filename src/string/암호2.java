package string;

import java.util.Scanner;

public class 암호2 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        String input = sc.next();

        String answer = solution(tc, input);

        System.out.println(answer);

    }

    public static String solution(int tc, String input) {

        String answer = "";

        for (int i = 0; i < tc; i++) {
            String password = input.substring(0, 7);

            password = password.replace("#", "1").replace("*", "0");

            int value = Integer.parseInt(password, 2);

            answer += (char) value;

            input = input.substring(7);

        }

        return answer;

    }
}
