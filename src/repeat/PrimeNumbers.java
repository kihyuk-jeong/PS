package repeat;

import jdk.jshell.Snippet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeNumbers {

    private static Set<Integer> numbers = new HashSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        recursive("", input);

        for (Integer value : numbers) {

//            if (isPrimeNumber(value)) {
//                System.out.println(value);
//            }
        }
    }

    private static boolean isPrimeNumber(Integer value) {

        if (value == 0 || value == 1) {
            return false;
        }

        int limit = (int) Math.sqrt(value);

        for (int i = 2; i <= limit; i++) {

            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void recursive(String comp, String input) {

        if (!comp.isEmpty()) {
            numbers.add(Integer.parseInt(comp));
        }

        for (int i = 0; i < input.length(); i++) {
            recursive(comp + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
        }

    }

}
