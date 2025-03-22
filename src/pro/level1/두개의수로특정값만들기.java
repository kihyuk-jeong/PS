package pro.level1;

import java.util.HashSet;
import java.util.Set;

public class 두개의수로특정값만들기 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 8};
        int target = 6;

//        int[] arr = {2, 3, 5, 9};
//        int target = 10;


        boolean answer = solution(arr, target);
        System.out.println(answer);
    }

    private static boolean solution(int[] arr, int target) {

        Set<Integer> hashSet = new HashSet<>();

        for (int value : arr) {

            if (hashSet.contains(target - value)) {
                return true;
            }

            hashSet.add(value);
        }
        return false;
    }

}
