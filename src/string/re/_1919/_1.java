package string.re._1919;

import java.util.Scanner;

public class _1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String textA = sc.nextLine();
        String textB = sc.nextLine();

        int [] arrTextA = getAlphaCount(textA);
        int [] arrTextB = getAlphaCount(textB);

        int result = 0;

        for (int i = 0; i < 26; i++) {
            result += Math.abs(arrTextA[i] - arrTextB[i]);
        }

        System.out.println(result);

    }

    private static int[] getAlphaCount(String text) {

        int[] arr = new int[26];

        for (int i = 0; i < text.length(); i++) {
            arr[text.charAt(i) -'a']++;
        }
        return arr;
    }
}
