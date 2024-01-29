package string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class 중복문자제거 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        int length = input.length();

        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < length; i++) {
            set.add(input.charAt(i));
        }

        for (Character character : set) {
            System.out.print(character);
        }


    }
}
