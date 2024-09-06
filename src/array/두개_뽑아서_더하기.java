package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 두개_뽑아서_더하기 {

    static int n;
    static List<List<Integer>> answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        answer = new ArrayList<>();

        recur(array, 0, new ArrayList<>());

        Set<Integer> hashSet = new HashSet<>();

        for (List<Integer> list : answer) {
            hashSet.add(list.get(0) + list.get(1));
        }

        System.out.println(hashSet);


    }

    private static void recur(int[] array, int startIndex, ArrayList<Integer> current) {

        if (current.size() == 2) {

            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = startIndex; i < n; i++) {

            current.add(array[i]);
            recur(array, i + 1, current);
            current.remove(current.size() - 1);
        }


    }

}