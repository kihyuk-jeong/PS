package repeat;

import java.util.Scanner;

public class 점계 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int answer = 0 ;
        int sum = 0;

        int prev = array[0] == 0 ? 0 : 1;

        answer += prev;
        sum += answer;

        for (int i = 1; i < n; i++) {
            if (prev == 0 && array[i] == 1) {
                answer = 1;
            } else if (prev == 1 && array[i] == 1){
                answer++;
            } else {
                answer = 0;
            }
            prev = array[i];
            sum += answer;
        }

        System.out.println(sum);


    }

}
