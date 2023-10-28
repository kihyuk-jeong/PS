package bruteforce;

import java.util.Scanner;

public class 유레카이론_10448 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();


        while (tc-- > 0) {
            int k = sc.nextInt();

            int[] arr = new int[50];
            int index = 0;
            boolean isFind = false;
            for (int i = 1; i < 50; i++) {

                int samgaksu = i * (i + 1) / 2;

                if (samgaksu > k) {
                    break;
                }

                arr[index++] = samgaksu;

            }

            int index2 = 0;
            for (int i = 0; i < 50; i++) {
                if (arr[i] != 0) {
                    index2++;
                }
            }

            for (int i = 0; i < index2; i++) {
                for (int j = 0; j < index2; j++) {
                    for (int z = 0; z < index2; z++) {
                        if (arr[i] + arr[j] + arr[z] == k) {
                            isFind = true;
                            break;
                        }
                    }
                    if (isFind) {
                        break;
                    }
                }
                if (isFind) {
                    break;
                }
            }

            if (isFind) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
