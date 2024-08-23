package bruteforce;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839#
 * 프로그래머스 레벨 2 / 완전탐색
 */

public class 소수찾기요 {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int answer = 0;

        recursive("", input);

        for (Integer value : set) {
            if (isPrimeNumber(value)) {
                answer++;
            }
        }

        System.out.println(answer);

        System.out.println(set);

    }


    private static void recursive(String comp, String input) {

        System.out.println("comp : " + comp);
        System.out.println("input : " + input);
        System.out.println();

        if (!"".equals(comp)) {
            set.add(Integer.parseInt(comp));
        }

        // 17

        for (int i = 0; i < input.length(); i++) {
            recursive(comp + input.charAt(i), input.substring(0, i) + input.substring(i+1));
        }


    }

    private static boolean isPrimeNumber(int number) {

        if (number == 0 || number == 1) {
            return false;
        }

        int limit = (int) Math.sqrt(number);

        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
