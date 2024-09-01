package recursive;

import java.util.Scanner;

public class Seq {
    static int n;
    static boolean[] ch;

    public static void DFS(int L) {

        if (L == n + 1) {

            for (int i = 1; i <= n; i++) {
                System.out.print(ch[i] ? i + " " : "");
            }
            System.out.println();
            return;

        }
        ch[L] = true;
        DFS(L + 1);
        ch[L] = false;
        DFS(L + 1);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        ch = new boolean[n + 1];

        DFS(1);

    }
}
