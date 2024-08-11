import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        boolean[][] test = new boolean[5][10];

        test[3][2] = true;
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                System.out.print(test[i][j] + " ");
            }
        }

    }
}