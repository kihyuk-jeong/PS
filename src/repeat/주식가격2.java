package repeat;

import java.util.Arrays;
import java.util.Scanner;

public class 주식가격2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int[] answer = solve(arr);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] solve(int[] arr) {

        int n = arr.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                answer[i]++;
                if (arr[i] > arr[j]) {
                    break;
                }

            }
        }

        return answer;

    }
}
