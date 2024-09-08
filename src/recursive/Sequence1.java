package recursive;

import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sequence1 {

    static int n,m;

    static List<List<String>> result = new ArrayList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        recur(0, new ArrayList<>());

        for (List<String> list : result) {
            System.out.println(list);
        }


    }
    private static void recur(int number, List<String> letter) {

        if (number == m) {
            result.add(new ArrayList<>(letter));
            return;
        }

        for (int i = 1; i <= n; i++) {
            letter.add(String.valueOf(i));
            recur(number + 1, letter);
            letter.remove(letter.size() - 1);
        }
    }
}
