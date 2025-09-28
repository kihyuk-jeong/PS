package silver;

import java.util.Scanner;

public class 크로아티아알파벳_simple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(String alphabet : croatianAlphabets) {
            input = input.replace(alphabet, "*");
        }

        System.out.println(input);
    }
}
