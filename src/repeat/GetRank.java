package repeat;

import java.util.Scanner;

public class GetRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        solve(n, array);
    }

    private static void solve(int n, int[] array) {

        int[] answer = new int[n];
        for(int i =0; i<n; i++){
            int rank = 1;
            for (int j = 0; j < n; j++) {

                if (array[i] < array[j]) {
                    rank++;
                }

            }

            answer[i] = rank;
        }

        for (int s : answer) {
            System.out.print(s +" ");
        }

    }
}
