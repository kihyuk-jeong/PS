package silver;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2941
 */
public class 크로아티아알파벳 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int count = 0;

        String check1 = "dz=";
        String[] check2 = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < input.length() - 1; ) {
            if (i < input.length() - 2 && check1.equals(input.substring(i, i + 3))) {
                i += 3;
                count += 2;
            } else {
                boolean isMatch = false;
                String now = input.substring(i, i + 2);
                for (String s : check2) {
                    if (now.equals(s)) {
                        i += 2;
                        count++;
                        isMatch = true;
                    }
                }

                if (!isMatch) {
                    i++;
                }

            }
        }

        System.out.println(input.length() - count);


    }

}
