package repeat;

import java.util.Scanner;

public class ScoreCalculation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solve(array));
    }

    public static int solve(int[] array) {

        int n = array.length;

        int total = array[0];
        int count = 0;


        for (int i = 1; i < n; i++) {

            if (array[i] == 1) {

                if (array[i - 1] == 0) {
                    total+=1;
                    count =0;
                } else {
                    count++;
                    total = total+count+1;
                }


            }


        }

        return total;

    }

}
