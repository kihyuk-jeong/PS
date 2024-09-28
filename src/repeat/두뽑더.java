package repeat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// 숫자를 입력받아서 2개를 뽑아서 더한 집합 구하기 (중복 X)
public class 두뽑더 {

    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        boolean[] used = new boolean[n];


//        recur(0, 0, array, new ArrayList<>());

        recur2(0, 0, array, used, new ArrayList<>());
        Set<Integer> results = new HashSet<>();

        for (List<Integer> values : list) {

            System.out.println(values);

            int valueSum = values.stream()
                    .mapToInt(t -> t)
                    .sum();

            results.add(valueSum);
        }

        System.out.println(results);
    }

    private static void recur(int count, int start, int[] array, List<Integer> letter) {

        if (count == 2) {
            list.add(new ArrayList<>(letter));
            return;
        }


        for (int i = start; i < array.length; i++) {

            letter.add(array[i]);
            recur(count + 1, i + 1, array, letter);
            letter.remove(letter.size() - 1);
        }
    }

    private static void recur2(int count, int start, int[] array, boolean[] used, List<Integer> letter) {

        if (count == 2) {
            list.add(new ArrayList<>(letter));
            return;
        }

        for (int i = start; i < array.length; i++) {
//
//            if (used[i]) {
//                continue;
//            }

//            used[i] = true;
            letter.add(array[i]);
            recur2(count + 1, i + 1, array, used, letter);
            letter.remove(letter.size() - 1);
//            used[i] = false;
        }
    }
}
