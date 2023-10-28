package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2309
public class 일곱난쟁이_2309 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] smallPeople = new int[9];
        int[] answer = new int[7];

        for (int i = 0; i < 9; i++) {
            smallPeople[i] = sc.nextInt();
        }

        int sum = sum(smallPeople);

        for (int i = 0; i < 9; i++) {
            boolean isFind = false;
            for (int j = i + 1; j < 9; j++) {


                if (sum - smallPeople[i] - smallPeople[j] == 100) {
                    isFind = true;
                    int index = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            answer[index++] = smallPeople[k];
                        }
                    }

                    break;
                }
            }

            if (isFind) {
                break;
            }
        }

        Arrays.sort(answer);

        Arrays.stream(answer)
                .forEach(System.out::println);

    }

    private static int sum(int[] smallPeople) {

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += smallPeople[i];
        }

        return sum;
    }
}
