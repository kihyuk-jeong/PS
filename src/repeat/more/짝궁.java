package repeat.more;

import java.util.Arrays;
import java.util.Scanner;

public class 짝궁 {

    // 뒤로 갈수록 높아져야 하는데, 갑자기 낮아지면 바로 이전 인덱스가 철수
    // 계속 진행 하다가 반대로, 낮아지면 짝궁

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int[] temp = array.clone();
        Arrays.sort(array);

        for (int i = 0; i < n; i++) {
            if (temp[i] != array[i]) {
                System.out.print((i+1) + " ");
            }
        }


    }

}
