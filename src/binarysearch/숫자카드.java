package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. 숫자카드 (정수 하나가 적혀져 있는 카드임) N 개를 가지고 있음.
 * * 2. 정수 M 개가 주어졌을 때 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지 구하는.
 * * 입력 : N (숫자 카드의 개수) / 숫자 카드에 적혀있는 정수 /  M  / 가지고 있는지 가지고 있지 않은지 판단  * ->
 */
public class 숫자카드 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] finders = new int[m];


        for (int i = 0; i < m; i++) {
            finders[i] = sc.nextInt();
        }

        int[] answer = solve(numbers, finders);

        for (int value : answer) {
            System.out.print(value + " ");
        }


    }

    private static int[] solve(int[] numbers, int[] finders) {

        Arrays.sort(numbers);

        int[] answer = new int[finders.length];


        for (int i = 0; i < finders.length; i++) {

            if (search(numbers, finders[i])) {
                answer[i] = 1;

            } else {
                answer[i] = 0;
            }

        }

        return answer;
    }

    private static boolean search(int[] numbers, int target) {

        int lt = 0;
        int rt = numbers.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (target > numbers[mid]) {
                lt = mid + 1;
            } else if (target < numbers[mid]) {
                rt = mid - 1;
            } else {
                return true;
            }

        }
        return false;
    }
}