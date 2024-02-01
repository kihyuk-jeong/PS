package string;

import java.util.Scanner;

public class 암호 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        String pw = sc.next();

        System.out.println(solve(tc, pw));

    }

    public static String solve(int tc, String pw) {

        String answer = "";

        for (int i = 0; i < tc; i++) {
            String temp = pw.substring(0, 7);

            String binaryNumbers = getBinaryNumbers(temp);
            int decimalNumber = getDecimalNumber(binaryNumbers);

            pw = pw.substring(7);

            answer += (char) decimalNumber;
        }

        return answer;

    }

    private static String getBinaryNumbers(String temp) {

        return temp.replace("#", "1").replace("*", "0");
    }

    private static int getDecimalNumber(String binaryNumbers) {

        int decimalNumber = 0;
        int powCount = 6;

        for (int i = 0; i < binaryNumbers.length(); i++) {

            if (binaryNumbers.charAt(i) == '1') {
                decimalNumber += (int) Math.pow(2, powCount);
            }
            powCount--;
        }
        return decimalNumber;
    }
}
