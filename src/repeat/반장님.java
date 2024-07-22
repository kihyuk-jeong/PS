package repeat;

import java.util.Scanner;

public class 반장님 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] array = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        solve(n, array);

    }

    private static void solve(int n, int[][] array) {

        int max = Integer.MIN_VALUE;
        int answer = 0;
        int count;

        for (int i = 0; i < n; i++) {

            count = 0;

            for (int j = 0; j < n; j++) {

                for (int k = 0; k < 5 && i != j; k++) {

                    int current = array[i][k];
                    int next = array[j][k];


                    // 중요 : current 와 next 는 이미 같은반을 1번 했기 때문에 break 로 빠져나간다.
                    if (current == next) {
                        count++;
                        break;
                    }
                }
            }

            if (max < count) {
                max = count;
                answer = i;
            }
        }
        System.out.println(answer + 1);
    }
}
